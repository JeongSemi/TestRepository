package com.mycompany.myapp.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StatusController {

//	@RequestMapping("/status/rgbled")
//	public void rgbled(String rgbRed, String rgbGreen, String rgbBlue) throws IOException {
//
//		System.out.println(rgbRed + rgbGreen + rgbBlue);

		// String resJson = json.toString();
		//
		// response.setContentType("application/json; charset=UTF-8");
		// PrintWriter pw = response.getWriter();
		// pw.write(resJson);
		// pw.flush();
		// pw.close();
//	}

	// @RequestMapping("/status/lcd")
	// public void photoresistorsensor(String command, HttpServletResponse
	// response) throws IOException {
	//
	// JSONObject jsonObject = new JSONObject();x
	// jsonObject.put("command", command);
	// String reqJson = jsonObject.toString();
	// CoapClient coapClient = new CoapClient();
	// coapClient.setURI(uri + "/photoresistorsensor");
	// CoapResponse coapResponse = coapClient.post(reqJson,
	// MediaTypeRegistry.APPLICATION_JSON);
	// String resJson = coapResponse.getResponseText();
	//
	// response.setContentType("application/json; charset=UTF-8");
	// PrintWriter pw = response.getWriter();
	// pw.write(resJson);
	// pw.flush();
	// pw.close();
	// }

	@RequestMapping("/status/buzzer") // 매핑경로는 이름에 맞게
	public void buzzerStatus(String command, String value, HttpServletResponse response) throws Exception {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("command", command);
		jsonObject.put("value", value);
		String reqJson = jsonObject.toString();

		PrintWriter pw = response.getWriter();
		pw.write(reqJson);
		pw.flush();
		pw.close();
	}

	// @RequestMapping("/actuator/laseremitter")
	// public void laseremitterStatus(String command, String value,
	// HttpServletResponse response) throws Exception {
	//
	// JSONObject jsonObject = new JSONObject();
	// jsonObject.put("command", command);
	// jsonObject.put("value", value);
	// String reqJson = jsonObject.toString();
	//
	// PrintWriter pw = response.getWriter();
	// pw.write(reqJson);
	// pw.flush();
	// pw.close();
	// }

}
