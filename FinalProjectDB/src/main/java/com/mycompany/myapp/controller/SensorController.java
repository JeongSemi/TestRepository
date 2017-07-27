package com.mycompany.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SensorController {

	@RequestMapping("/sensor/temperature")
	public String temperature() {

		return "sensor/temperature";
	}

	@RequestMapping("/sensor/gas")
	public String gas() {

		return "sensor/gas";
	}

	@RequestMapping("/sensor/humidity")
	public String humidity() {

		return "sensor/humidity";
	}

	@RequestMapping("/sensor/mercury")
	public String mercury() {

		return "sensor/mercury";
	}

	@RequestMapping("/sensor/photoresistor")
	public String photoresistor() {

		return "sensor/photoresistor";
	}

	@RequestMapping("/sensor/pressure")
	public String pressure() {

		return "sensor/pressure";
	}

	@RequestMapping("/sensor/raindrop")
	public String raindrop() {

		return "sensor/raindrop";
	}

	@RequestMapping("/sensor/touch")
	public String touch() {

		return "sensor/touch";
	}

}
