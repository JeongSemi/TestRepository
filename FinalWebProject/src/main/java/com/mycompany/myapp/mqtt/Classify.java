package com.mycompany.myapp.mqtt;

import org.json.JSONObject;

public class Classify {

	public static double temperature;
	public static double gas;
	public static double humidity;
	public static double photoresistor;
	public static double pressure;
	public static double raindrop;
	public static String mercury;
	public static String touch;
	public static int rgbRed;
	public static int rgbGreen;
	public static int rgbBlue;
	public static String buzzer;
	public static String laser;
	public static String lcdline0;
	public static String lcdline1;
	public static int cameraUpdown;
	public static int cameraLeftright;
	public static int fronttireAngle;
	public static int motorSpeed;

	JSONObject jsonObject;
	public String command;

	public void classifySensor(String message) {

		jsonObject = new JSONObject(message);
		command = jsonObject.getString("command");

		if (command.equals("temperature")) {
			temperature = jsonObject.getDouble("value");
		} else if (command.equals("gas")) {
			gas = jsonObject.getDouble("value");
		} else if (command.equals("humidity")) {
			humidity = jsonObject.getDouble("value");
		} else if (command.equals("photoresistor")) {
			photoresistor = jsonObject.getDouble("value");
		} else if (command.equals("pressure")) {
			pressure = jsonObject.getDouble("value");
		} else if (command.equals("raindrop")) {
			raindrop = jsonObject.getDouble("value");
		} else if (command.equals("mercury")) {
			mercury = jsonObject.getString("value");
		} else if (command.equals("touch")) {
			touch = jsonObject.getString("value");
		}

	}

	public void classifyActuator(String message) {
		jsonObject = new JSONObject(message);
		buzzer = jsonObject.getString("buzzer");
		rgbRed = jsonObject.getInt("red");
		rgbGreen = jsonObject.getInt("green");
		rgbBlue = jsonObject.getInt("blue");
		laser = jsonObject.getString("laser");
		lcdline0 = jsonObject.getString("lcdline0");
		lcdline1 = jsonObject.getString("lcdline1");
		cameraUpdown = jsonObject.getInt("cameraupdown");
		cameraLeftright = jsonObject.getInt("cameraleftright");
		fronttireAngle = jsonObject.getInt("fronttireangle");
		motorSpeed = jsonObject.getInt("motorspeed");
	}

}
