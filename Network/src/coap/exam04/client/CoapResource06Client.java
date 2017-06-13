package coap.exam04.client;

import java.io.IOException;
import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapHandler;
import org.eclipse.californium.core.CoapObserveRelation;
import org.eclipse.californium.core.CoapResponse;

public class CoapResource06Client {

    //Field
    private CoapClient coapClient;
    private CoapObserveRelation coapObserveRelation;
    private int preVal = -1;
    private int currVal;

    //Constructor
    public CoapResource06Client() {
        coapClient = new CoapClient();
    }

    //Method
    public void observe() {
        coapClient.setURI("coap://192.168.3.30/resource06");
        coapObserveRelation = coapClient.observe(new CoapHandler() {
            @Override
            public void onLoad(CoapResponse response) {
                String text = response.getResponseText();
                currVal = Integer.parseInt(text);
                // 초기 정상상태 출력
                if (preVal == -1 && currVal <= 200) {
                    System.out.println("정상 상태");
                }
                // 200이 넘으면 가스검출 출력
                if (currVal > 200) {
                    System.out.println("가스 검출");
                } else if (currVal <= 200 && preVal > 200) {
                    System.out.println("정상 상태");
                }
                preVal = currVal;
            }

            @Override
            public void onError() {
            }
        });
    }

    public void shutdown() {
        coapObserveRelation.proactiveCancel();
        coapClient.shutdown();
    }

    public static void main(String[] args) throws IOException {
        CoapResource06Client client = new CoapResource06Client();
        client.observe();
        System.in.read();
        client.shutdown();
    }
}
