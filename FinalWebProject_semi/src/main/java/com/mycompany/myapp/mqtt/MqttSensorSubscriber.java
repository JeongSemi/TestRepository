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
public class MqttSensorSubscriber {
	private static final Logger LOGGER = LoggerFactory.getLogger(MqttSensorSubscriber.class);

	public MqttClient mqttClient;
	public MqttCallback mqttCallback;
	Classify classify = new Classify();
	JSONObject jsonObject;

	public MqttSensorSubscriber() throws MqttException {
		LOGGER.info("subscriber constructor 실행");
		mqttClient = new MqttClient(MqttPublisher.brokerURI, MqttClient.generateClientId());
		mqttCallback = new MqttCallback() {

			@Override
			public void messageArrived(String string, MqttMessage mm) throws Exception {
				String subJson = new String(mm.getPayload());
				classify.classifySensor(subJson);
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

		mqttClient.subscribe("/rc_sensing_robo/sensor");
	}

	@PreDestroy
	public void destroy() throws MqttException {
		LOGGER.info("destroy 실행");
		mqttClient.disconnect();
		mqttClient.close();
	}

}
