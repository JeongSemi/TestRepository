package com.mycompany.myapp.mqtt;

import javax.annotation.PreDestroy;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class MqttPublisher {

	private MqttClient mqttClient;

	// Constructor
	public MqttPublisher() throws MqttException {
		// MQTT 클라이언트 생성
		mqttClient = new MqttClient("tcp://52.78.170.231:1883", MqttClient.generateClientId());
		// 통신 결과에 따라 콜백 메소드를 실행할 콜백 객체 생성(생성 안함)

		// MQTT 브로커와 연결하기
		mqttClient.connect();
	}

	// Method
	public void publish(String command, String value) throws MqttException {

		JSONObject jsonObject = null;
		jsonObject = new JSONObject();
		jsonObject.put("command", command);
		jsonObject.put("value", value);
		String pubJson = jsonObject.toString();

		// MQTT 브로커로 보내는 메시지 생성
		MqttMessage message = new MqttMessage(pubJson.getBytes());
		// 지정한 토픽 MQTT 브로커로 메시지 보냄
		mqttClient.publish("/rc_sensing_robo/actuator", message);
	}

	public void publish(String command, String value1, String value2) throws MqttException {

		JSONObject jsonObject = null;
		jsonObject = new JSONObject();
		jsonObject.put("command", command);
		jsonObject.put("value1", value1);
		jsonObject.put("value2", value2);
		String pubJson = jsonObject.toString();

		// MQTT 브로커로 보내는 메시지 생성
		MqttMessage message = new MqttMessage(pubJson.getBytes());
		// 지정한 토픽 MQTT 브로커로 메시지 보냄
		mqttClient.publish("/rc_sensing_robo/actuator", message);
	}

	public void publish(String command, String value1, String value2, String value3) throws MqttException {

		JSONObject jsonObject = null;
		jsonObject = new JSONObject();
		jsonObject.put("command", command);
		jsonObject.put("value1", value1);
		jsonObject.put("value2", value2);
		jsonObject.put("value3", value3);
		String pubJson = jsonObject.toString();

		// MQTT 브로커로 보내는 메시지 생성
		MqttMessage message = new MqttMessage(pubJson.getBytes());
		// 지정한 토픽 MQTT 브로커로 메시지 보냄
		mqttClient.publish("/rc_sensing_robo/actuator", message);
	}

	@PreDestroy
	public void destroy() throws MqttException {
		// MQTT 브로커와 연결끊기
		mqttClient.disconnect();
		// MqttClient가 사용한 리소스(메모리)를 해제
		mqttClient.close();

	}
}
