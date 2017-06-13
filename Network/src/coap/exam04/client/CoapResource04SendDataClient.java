package coap.exam04.client;

import java.util.Random;
import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.json.JSONObject;

public class CoapResource04SendDataClient {

    //Field
    private CoapClient coapClient;

    //Constructor
    public CoapResource04SendDataClient() {
        coapClient = new CoapClient();
    }

    //Method
    public void post() {
        coapClient.setURI("coap://192.168.3.30/resource04");
        Random random = new Random();
        while (true) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("value", random.nextInt(50)); // 0~49
            String json = jsonObject.toString();
            coapClient.post(json, MediaTypeRegistry.APPLICATION_JSON); //동기방식이지만 응답내용을 받지않는다. 왜? 필요없기때문에
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }

    public void shutdown() {
        coapClient.shutdown();
    }

    public static void main(String[] args) {
        CoapResource04SendDataClient client = new CoapResource04SendDataClient();
        client.post();
        client.shutdown();
    }
}
