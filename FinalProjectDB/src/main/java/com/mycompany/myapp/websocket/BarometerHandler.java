package com.mycompany.myapp.websocket;

import java.util.List;
import java.util.Vector;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.mycompany.myapp.dto.Barometer;
import com.mycompany.myapp.service.SensorService;

@Component
public class BarometerHandler extends TextWebSocketHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(BarometerHandler.class);

	@Autowired
	private SensorService service;
	
	private List<WebSocketSession> list = new Vector<>();

	private MqttClient mqttClient;
	private MqttCallback mqttCallback;

	@PostConstruct
	public void init() throws Exception {
		LOGGER.info("init 실행");
		mqttClient = new MqttClient("tcp://192.168.3.217:1883", MqttClient.generateClientId());
		mqttCallback = new MqttCallback() {

			@Override
			public void messageArrived(String string, MqttMessage mm) throws Exception {
				String subJson = new String(mm.getPayload());
				System.out.println("*BarometerHandler*messageArrived: " + subJson);
				JSONObject jsonObject = new JSONObject(subJson);
				double temperature = jsonObject.getDouble("temperature");
//				double pressure = jsonObject.getDouble("pressure");
				Barometer barometer = new Barometer();
				barometer.setTemperature(temperature);
				barometer.setPressure(1000);
				
						service.barometerDataIn(barometer);
				
				
				for (WebSocketSession session : list) {
					session.sendMessage(new TextMessage(subJson));
				}
			}

			@Override
			public void deliveryComplete(IMqttDeliveryToken arg0) {
			}

			@Override
			public void connectionLost(Throwable arg0) {
			}
		};
		mqttClient.setCallback(mqttCallback);
		mqttClient.connect();

		mqttClient.subscribe("/devices/device1/temperature");
	}

	@PreDestroy
	public void destroy() throws Exception {
		mqttClient.disconnect();
		mqttClient.close();
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		LOGGER.info("afterConnectionEstablished 실행");

		list.add(session);
	}

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		LOGGER.info("handleTextMessage실행");
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		LOGGER.info("afterConnectionClosed실행");
		list.remove(session);
	}

}
