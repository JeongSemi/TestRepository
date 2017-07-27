package rccar.mqtt.publisher;

import java.util.Date;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttPublisher {

	private MqttClient mqttClient;
	private MqttCallback mqttCallback = new MqttCallback() {
		@Override
		public void connectionLost(Throwable thrwbl) {
		}

		@Override
		public void messageArrived(String string, MqttMessage mm) throws Exception {
		}

		@Override
		public void deliveryComplete(IMqttDeliveryToken imdt) {
			System.out.println("deliveryComplete: " + new Date());
		}
	};

	//Constructor
	public MqttPublisher() throws MqttException {
		//MQTT 클라이언트 생성
		mqttClient = new MqttClient("tcp://192.168.3.217:1883", MqttClient.generateClientId());
		//통신 결과에 따라 콜백 메소드를 실행할 콜백 객체 생성
		mqttClient.setCallback(mqttCallback);
		//MQTT 브로커와 연결하기
		mqttClient.connect();
	}

	//Method
	public void publish(String text) throws MqttException {
		//MQTT 브로커로 보내는 메시지 생성
		MqttMessage message = new MqttMessage(text.getBytes());
		//지정한 토픽 MQTT 브로커로 메시지 보냄
		mqttClient.publish("/sensingrobo/send", message);
	}

	public void shutdown() throws MqttException {
		//MQTT 브로커와 연결끊기
		mqttClient.disconnect();
		//MqttClient가 사용한 리소스(메모리)를 해제
		mqttClient.close();
	}
}
