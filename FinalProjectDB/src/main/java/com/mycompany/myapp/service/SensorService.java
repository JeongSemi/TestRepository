package com.mycompany.myapp.service;

import com.mycompany.myapp.dto.Gas;
import com.mycompany.myapp.dto.Humidity;
import com.mycompany.myapp.dto.Pressure;
import com.mycompany.myapp.dto.Temperature;

public interface SensorService {
	public void temperatureDataIn(Temperature temperature);
	public void gasDataIn(Gas gas);
	public void pressureDataIn(Pressure pressure);
	public void humidityDataIn(Humidity humidity);

}
