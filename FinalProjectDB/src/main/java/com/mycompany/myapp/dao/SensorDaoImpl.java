package com.mycompany.myapp.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dto.Gas;
import com.mycompany.myapp.dto.Humidity;
import com.mycompany.myapp.dto.Pressure;
import com.mycompany.myapp.dto.Temperature;

@Component
public class SensorDaoImpl implements SensorDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(SensorDaoImpl.class);

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int temperatureInsert(Temperature temperature) {

		sqlSessionTemplate.insert("temperature.insert", temperature);
		int tno = temperature.getTno();

		LOGGER.info("Temperature insert 성공");
		return tno;

	}

	@Override
	public int gasInsert(Gas gas) {
		sqlSessionTemplate.insert("gas.insert", gas);
		int gno = gas.getGno();

		LOGGER.info("Gas insert 성공");
		return gno;
	}

	@Override
	public int pressureInsert(Pressure pressure) {
		sqlSessionTemplate.insert("pressure.insert", pressure);
		int prno = pressure.getPrno();

		LOGGER.info("Pressure insert 성공");
		return prno;
	}

	@Override
	public int humidityInsert(Humidity humidity) {
		sqlSessionTemplate.insert("humidity.insert", humidity);
		int hno = humidity.getHno();

		LOGGER.info("Humidity insert 성공");
		return hno;
	}

	@Override
	public List<Humidity> humiditySelectByMinute() {
		Map<String, Object> map = new HashMap<String, Object>();
		Date currDateTime = new Date();
		String selectDate = new SimpleDateFormat("yyyyMMdd").format(currDateTime);
		String selectFromTime = selectDate + "095800";
		String selectToTime = selectDate + "095859";
		System.out.println(selectDate);
		map.put("selectFromTime", selectFromTime);
		map.put("selectToTime", selectToTime);
		List<Humidity> list = sqlSessionTemplate.selectList("humidity.selectByMinute", map);

		LOGGER.info("SELECT By Second 성공");

		return list;
	}

}
