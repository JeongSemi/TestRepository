package coap.exam02.client;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.json.JSONObject;

public class CoapResource02Client {

    //Field
    private CoapClient coapClient;

    //Constructor
    public CoapResource02Client() {
        coapClient = new CoapClient();
        coapClient.useNONs();
    }

    //Method 
    //GET 방식은 json 사용 불가
    public String get(int angle) {
        String queryString = "kind=ultrasonicsensor&angle=" + angle;
        coapClient.setURI("coap://192.168.3.30:5683/resource02?" + queryString);
        CoapResponse response = coapClient.get();
        if (response == null) {
            return get(angle); //재귀호출
        } else {
            if (response.getCode() == CoAP.ResponseCode.CONTENT) {
                return response.getResponseText();
            } else {
                return get(angle);
            }
        }
    }

    public String post(int angle) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("kind", "ultrasonicsensor");
        jsonObject.put("angle", angle);
        String json = jsonObject.toString();
        coapClient.setURI("coap://192.168.3.30:5683/resource02");
        CoapResponse response = coapClient.post(json, MediaTypeRegistry.APPLICATION_JSON);
        if (response == null) {
            return get(angle); //재귀호출
        } else {
            if (response.getCode() == CoAP.ResponseCode.CONTENT) {
                return response.getResponseText();
            } else {
                return get(angle);
            }
        }
    }

    public void shutdown() {
        coapClient.shutdown();
    }

    public static void main(String[] args) throws Exception {
        CoapResource02Client client = new CoapResource02Client();

        for (int i = 10; i <= 170; i += 10) {
            String text = client.post(i);
            System.out.println(i + "각도 거리: " + text);
        }

        for (int i = 170; i >= 10; i -= 10) {
            String text = client.post(i);
            System.out.println(i + "각도 거리: " + text);
        }
        client.post(90);
        client.shutdown();
    }
}
