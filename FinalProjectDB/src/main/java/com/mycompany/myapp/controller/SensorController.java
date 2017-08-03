package com.mycompany.myapp.controller;

import java.security.Provider.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.myapp.dto.Humidity;
import com.mycompany.myapp.service.SensorService;

@Controller
public class SensorController {

	@Autowired
	SensorService service;

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

	@RequestMapping("/sensor/humidityselect")
	public String humiditySelect(Model model) {
		List<Humidity> list = service.humidityMinuteData();
		model.addAttribute("list", list);
		return "sensor/humidityselect";
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
