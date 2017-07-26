package sensingcar;

import hardware.converter.PCF8591;
import hardware.sensor.ThermistorSensor;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.json.JSONObject;
import sensingcar.mqtt.publisher.MqttPublisher;

public class MqttSensingCar {

	private ThermistorSensor thermistorSensor;
	private PCF8591 pcf8591;
	private double currTemperature;
	MqttPublisher mqttPublisher;

	public MqttSensingCar() throws Exception {
		thermistorSensor = new ThermistorSensor(pcf8591);
		pcf8591 = new PCF8591(0x48, PCF8591.AIN1);
		thermistorSensor = new ThermistorSensor(pcf8591);
	}

	public void start() throws Exception {
		mqttPublisher = new MqttPublisher();
		JSONObject jsonObject = null;
		while (true) {
			jsonObject = new JSONObject();
			currTemperature = thermistorSensor.getValue();
			jsonObject.put("temperature", currTemperature);
			String pubJson = jsonObject.toString();
			mqttPublisher.publish(pubJson);
			Thread.sleep(1000);
		}
	}

	public void stop() throws MqttException {
		mqttPublisher.shutdown();
	}

	public static void main(String[] args) throws Exception {
		MqttSensingCar rcCar = new MqttSensingCar();
		rcCar.start();
		System.out.println("-RcCar Publisher Start-");
		System.in.read();
		System.out.println("press any key to quit");
		//클라이언트 종료
		rcCar.stop();
	}

}
