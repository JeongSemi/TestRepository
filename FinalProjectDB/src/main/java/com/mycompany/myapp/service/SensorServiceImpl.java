package com.mycompany.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.SensorDao;
import com.mycompany.myapp.dto.Gas;
import com.mycompany.myapp.dto.Humidity;
import com.mycompany.myapp.dto.Pressure;
import com.mycompany.myapp.dto.Temperature;

@Component
public class SensorServiceImpl implements SensorService {

	@Autowired
	private SensorDao dao;

	@Override
	public void temperatureDataIn(Temperature temperature) {
		dao.temperatureInsert(temperature);
	}

	@Override
	public void gasDataIn(Gas gas) {
		dao.gasInsert(gas);
	}
	
	@Override
	public void pressureDataIn(Pressure pressure) {
		dao.pressureInsert(pressure);
	}
	
	@Override
	public void humidityDataIn(Humidity humidity) {
		dao.humidityInsert(humidity);
	}
	
	@Override
	public List<Humidity> humidityMinuteData() {
		List<Humidity> list = dao.humiditySelectByMinute();
		return list;
	}
}
