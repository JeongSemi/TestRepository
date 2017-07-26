package com.mycompany.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.SensorDao;
import com.mycompany.myapp.dto.Barometer;

@Component
public class SensorServiceImpl implements SensorService {
	
	@Autowired
	private SensorDao dao;
	
	@Override
	public void barometerDataIn(Barometer barometer) {
		System.out.println("service");
		dao.barometerInsert(barometer);
	}
}
