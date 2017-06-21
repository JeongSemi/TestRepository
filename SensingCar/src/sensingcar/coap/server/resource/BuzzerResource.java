package sensingcar.coap.server.resource;

import com.pi4j.io.gpio.RaspiPin;
import hardware.buzzer.ActiveBuzzer;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BuzzerResource extends CoapResource {

    //Field
    private static final Logger logger = LoggerFactory.getLogger(BuzzerResource.class);
    private ActiveBuzzer buzzer;
    private String currStatus;

    //Constructor
    public BuzzerResource() throws Exception {
        super("buzzer");
        buzzer = new ActiveBuzzer(RaspiPin.GPIO_24);
        off();
    }

    //Method
    private void on() {
        buzzer.on();
        currStatus = "on";
    }

    private void off() {
        buzzer.off();
        currStatus = "off";
    }

    @Override
    public void handleGET(CoapExchange exchange) {
    }

    @Override
    public void handlePOST(CoapExchange exchange) {
        //ex. {"command":"change", "status":"on"}
        //ex. {"command":"status"}
        try {
            String requestJson = exchange.getRequestText();
            JSONObject requestJsonObject = new JSONObject(requestJson);
            String command = requestJsonObject.getString("command");
            if (command.equals("change")) {
                String status = requestJsonObject.getString("status");
                if (status.equals("on")) {
                    on();
                } else if (status.equals("off")) {
                    off();
                }
            } else if (command.equals("status")) {
            }
            JSONObject responseJsonObject = new JSONObject();
            responseJsonObject.put("result", "success");
            responseJsonObject.put("status", currStatus);
            String responseJson = responseJsonObject.toString();
            exchange.respond(responseJson);
        } catch (Exception e) {
            JSONObject responseJsonObject = new JSONObject();
            responseJsonObject.put("result", "fail");
            String responseJson = responseJsonObject.toString();
            exchange.respond(responseJson);
        }
    }

}
