package com.mycompany.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SensorController {

	@RequestMapping("/sensor/temperature")
	public String thermistorsensor() {

		return "sensor/temperature";
	}

	@RequestMapping("/sensor/barometer")
	public String barometer() throws Exception {

		return "sensor/barometer";
	}
}
