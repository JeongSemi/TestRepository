package com.mycompany.myapp.websocket;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.Vector;

import javax.annotation.PostConstruct;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.mycompany.myapp.mqtt.Classify;

@Component
public class TemperatureHandler extends TextWebSocketHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(TemperatureHandler.class);

	private List<WebSocketSession> list = new Vector<>();

	@PostConstruct
	public void init() throws Exception {
		LOGGER.info("init 실행");
		Thread thread = new Thread() {
			public void run() {
				while (true) {
					try {
						JSONObject jsonObject = new JSONObject();
						jsonObject.put("time", getUTCTime(new Date().getTime()));
						jsonObject.put("temperature", Classify.temperature);
						String json = jsonObject.toString();
						for (WebSocketSession session : list) {
							session.sendMessage(new TextMessage(json));
						}
						Thread.sleep(1000);
					} catch (Exception e) {
					}
				}
			};
		};
		thread.start();
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

	public long getUTCTime(long localTime) {
		long utcTime = 0;
		TimeZone tz = TimeZone.getDefault();
		try {
			int offset = tz.getOffset(localTime);
			utcTime = localTime + offset;
		} catch (Exception e) {
		}
		return utcTime;
	}

}
