package coap.exam04.server;

import com.pi4j.io.gpio.RaspiPin;
import hardware.buzzer.ActiveBuzzer;
import hardware.converter.PCF8591;
import hardware.led.RgbLedDigital;
import hardware.sensor.GasSensor;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;

public class CoapResource06 extends CoapResource {

    //Field
    private int value;
    private PCF8591 pcf8591;
    private GasSensor gasSensor;
    RgbLedDigital rgbLed;
    ActiveBuzzer buzzer;

    //Constructor
    public CoapResource06() {
        super("resource06");
        pcf8591 = new PCF8591(0x48, PCF8591.AIN2);
        gasSensor = new GasSensor(pcf8591, RaspiPin.GPIO_23);
        rgbLed = new RgbLedDigital(RaspiPin.GPIO_04, RaspiPin.GPIO_05, RaspiPin.GPIO_06);
        buzzer = new ActiveBuzzer(RaspiPin.GPIO_24);
        //관찰 기능 활성화
        setObservable(true);
        //관찰 기능을 제공한다는 것을 클라이언트가 알 수 있도록 설정
        getAttributes().setObservable();
        //테스트
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        value = gasSensor.getValue();
                        if (value > 200) {
                            rgbLed.rgb(true, false, false);
                            buzzer.on();
                        } else {
                            rgbLed.rgb(false, false, false);
                            buzzer.off();
                        }
                        changed();
                        Thread.sleep(1000);
                    } catch (Exception ex) {
                    }
                }
            }
        };
        thread.start();

    }

    //Method
    @Override
    public void handleGET(CoapExchange exchange) {
        exchange.respond(String.valueOf(value));

    }

    @Override
    public void handlePOST(CoapExchange exchange) {
    }

}
