package com.mycompany.myapp.mqtt;

import javax.annotation.PreDestroy;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MqttStatusSubscriber {
	private static final Logger LOGGER = LoggerFactory.getLogger(MqttStatusSubscriber.class);

	public MqttClient mqttClient;
	public MqttCallback mqttCallback;
	Classify classify = new Classify();

	public MqttStatusSubscriber() throws MqttException {
		LOGGER.info("subscriber constructor 실행");
		mqttClient = new MqttClient("tcp://52.78.170.231:1883", MqttClient.generateClientId());
		mqttCallback = new MqttCallback() {

			@Override
			public void messageArrived(String string, MqttMessage mm) throws Exception {
				String subJson = new String(mm.getPayload());
				classify.classifyActuator(subJson);
			}

			@Override
			public void deliveryComplete(IMqttDeliveryToken arg0) {

			}

			@Override
			public void connectionLost(Throwable arg0) {
				arg0.printStackTrace();
			}
		};
		mqttClient.setCallback(mqttCallback);
		mqttClient.connect();

		mqttClient.subscribe("/rc_sensing_robo/status");
	}

	@PreDestroy
	public void destroy() throws MqttException {
		LOGGER.info("destroy 실행");
		mqttClient.disconnect();
		mqttClient.close();
	}

}
