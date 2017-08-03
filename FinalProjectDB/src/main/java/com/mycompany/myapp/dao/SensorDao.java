package com.mycompany.myapp.dao;

import java.util.List;

import com.mycompany.myapp.dto.Gas;
import com.mycompany.myapp.dto.Humidity;
import com.mycompany.myapp.dto.Pressure;
import com.mycompany.myapp.dto.Temperature;

public interface SensorDao {

	public int temperatureInsert(Temperature temperature);
	public int gasInsert(Gas gas);
	public int pressureInsert(Pressure pressure);
	public int humidityInsert(Humidity humidity);
	public List<Humidity> humiditySelectByMinute();
}
