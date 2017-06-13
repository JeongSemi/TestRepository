package coap.exam03.client;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapHandler;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.json.JSONObject;

public class CoapResource03AsyncClient {

    //Field
    private CoapClient coapClient;

    //Constructor
    public CoapResource03AsyncClient() {
        coapClient = new CoapClient();
    }

    //Method 
    //GET 방식은 json 사용 불가
    public void get(int angle) {
        String queryString = "kind=ultrasonicsensor&angle=" + angle;
        coapClient.setURI("coap://192.168.3.30:5683/resource02?" + queryString);

        coapClient.get(new CoapHandler() {
            //응답이 왔을 때 실행
            @Override
            public void onLoad(CoapResponse response) {
                if (response.getCode() == CoAP.ResponseCode.CONTENT) {
                    String text = response.getResponseText();
                    System.out.println(angle + "도 거리: " + text);
                } else {
                    get(angle);
                }
            }

            //에러가 발생했을 때(네트워크 통신두절 등)
            @Override
            public void onError() {
            }
        });

    }

    public void post(int angle) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("kind", "ultrasonicsensor");
        jsonObject.put("angle", angle);
        String json = jsonObject.toString();

        coapClient.setURI("coap://192.168.3.30:5683/resource02");
        coapClient.post(new CoapHandler() {
            @Override
            public void onLoad(CoapResponse response) {
                if (response.getCode() == CoAP.ResponseCode.CONTENT) {
                    String text = response.getResponseText();
                    System.out.println(angle + "도 거리: " + text);
                } else {
                    get(angle);
                }
            }

            @Override
            public void onError() {
            }
        }, json, MediaTypeRegistry.APPLICATION_JSON);

    }

    public void shutdown() {
        coapClient.shutdown();
    }

    public static void main(String[] args) throws Exception {
        CoapResource03AsyncClient client = new CoapResource03AsyncClient();

        for (int i = 10; i <= 170; i += 10) {
            client.post(i);
            Thread.sleep(1000);
        }

        for (int i = 170; i >= 10; i -= 10) {
            client.post(i);
            Thread.sleep(1000);
        }
        client.post(90);
        
        System.in.read();
        client.shutdown();
    }
}
