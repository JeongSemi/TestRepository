package com.mycompany.myapp.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.myapp.mqtt.MqttPublisher;

@Controller
public class ActuatorController {
	@Autowired
	private MqttPublisher publisher;

	private static final Logger logger = LoggerFactory.getLogger(ActuatorController.class);

	private static final String serverURI = "tcp://192.168.3.217:1883";

	private String topic = "/rc_sensing_robo/actuator";

	@RequestMapping("/actuator/motor")
	public void motor(String command, String value, HttpServletResponse response) throws MqttException {
		publisher.publish(command, value);

	}

	@RequestMapping("/actuator/fronttire")
	public void fronttire(String command, String value, HttpServletResponse response) throws MqttException {
		publisher.publish(command, value);

	}

	@RequestMapping("/actuator/buzzer")
	public void buzzer(String command, String value, HttpServletResponse response) throws Exception {
		publisher.publish(command, value);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("buzzer", value);

		String resJson = jsonObject.toString();

		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(resJson);
		pw.flush();
		pw.close();

	}

	@RequestMapping("/actuator/laseremitter")
	public void laseremitter(String command, String value, HttpServletResponse response) throws Exception {
		publisher.publish(command, value);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("laser", value);

		String resJson = jsonObject.toString();

		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(resJson);
		pw.flush();
		pw.close();

	}

	@RequestMapping("/actuator/lcd")
	public void lcd(String command, String value1, String value2, HttpServletResponse response) throws Exception {
		publisher.publish(command, value1, value2);

	}

	@RequestMapping("/actuator/rgbled")
	public void rgbled(String command, String value1, String value2, String value3, HttpServletResponse response)
			throws Exception {
		publisher.publish(command, value1, value2, value3);

	}

	@RequestMapping("/actuator/light")
	public void light(String command, String value, HttpServletResponse response) throws Exception {
		publisher.publish(command, value);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("light", value);

		String resJson = jsonObject.toString();

		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(resJson);
		pw.flush();
		pw.close();
		publisher.publish(command, value);
	}

	@RequestMapping("/actuator/camera")
	public void camera(String command, String value1, String value2, HttpServletResponse response) throws Exception {
		publisher.publish(command, value1, value2);
	}

}
