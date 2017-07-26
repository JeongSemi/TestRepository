package rccar;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.json.JSONObject;
import rccar.mqtt.publisher.MqttPublisher;
import rchardware.Barometer;

public class MqttRcCar {

	private Barometer barometer;
	MqttPublisher mqttPublisher;

	public MqttRcCar() throws Exception {
		barometer = new Barometer();
	}

	public void start() throws Exception {
		mqttPublisher = new MqttPublisher();
		double values[] = new double[3];
		JSONObject jsonObject = null;
		while (true) {
			jsonObject = new JSONObject();
			values = barometer.getValues();
			jsonObject.put("temperature", values[0]);
			jsonObject.put("pressure", values[2]);
			String pubJson = jsonObject.toString();
			mqttPublisher.publish(pubJson);
			Thread.sleep(1000);
		}
	}

	public void stop() throws MqttException {
		mqttPublisher.shutdown();
	}

	public static void main(String[] args) throws Exception {
		MqttRcCar rcCar = new MqttRcCar();
		rcCar.start();
		System.out.println("-RcCar Publisher Start-");
		System.in.read();
		System.out.println("press any key to quit");
		//클라이언트 종료
		rcCar.stop();
	}

}
