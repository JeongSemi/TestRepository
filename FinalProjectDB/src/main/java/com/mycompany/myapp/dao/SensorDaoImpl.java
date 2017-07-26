package com.mycompany.myapp.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dto.Barometer;

@Component
public class SensorDaoImpl implements SensorDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SensorDaoImpl.class);

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	@Override
	public int barometerInsert(Barometer barometer) {

		sqlSessionTemplate.insert("barometer.insert", barometer);
		int dataNo = barometer.getDataNo();
		
		LOGGER.info("insert 성공");
		return dataNo;
		
	}
}
