package com.mycompany.myapp.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StatusController {

	@RequestMapping("/status/rgbled")
	public void rgbledStatus(String rgbRed, String rgbGreen, String rgbBlue, HttpServletResponse response)
			throws Exception {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("rgbRed", rgbRed);
		jsonObject.put("rgbGreen", rgbGreen);
		jsonObject.put("rgbBlue", rgbBlue);
		String json = jsonObject.toString();

		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json);
		pw.flush();
		pw.close();
	}

	@RequestMapping("/status/lcd")
	public void lcdStatus(String lcdline0, String lcdline1, HttpServletResponse response) throws Exception {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("lcdline0", lcdline0);
		jsonObject.put("lcdline1", lcdline1);
		String json = jsonObject.toString();

		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json);
		pw.flush();
		pw.close();
	}

	@RequestMapping("/status/buzzer") // 매핑경로는 이름에 맞게
	public void buzzerStatus(String buzzer, HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("buzzer", buzzer);

		String resJson = jsonObject.toString();

		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(resJson);
		pw.flush();
		pw.close();
	}

	@RequestMapping("/status/laser") // 매핑경로는 이름에 맞게
	public void laserStatus(String laser, HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("laser", laser);

		String resJson = jsonObject.toString();

		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(resJson);
		pw.flush();
		pw.close();

	}

	@RequestMapping("/status/light") // 매핑경로는 이름에 맞게
	public void lightStatus(String light, HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("light", light);

		String resJson = jsonObject.toString();

		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(resJson);
		pw.flush();
		pw.close();
	}
}
