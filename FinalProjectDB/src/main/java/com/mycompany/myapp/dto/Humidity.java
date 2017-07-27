package com.mycompany.myapp.dto;

import java.util.Date;

public class Humidity {

	private int hno;
	private Date htime;
	private double humidity;

	public int getHno() {
		return hno;
	}

	public void setHno(int hno) {
		this.hno = hno;
	}

	public Date getHtime() {
		return htime;
	}

	public void setHtime(Date htime) {
		this.htime = htime;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

}
