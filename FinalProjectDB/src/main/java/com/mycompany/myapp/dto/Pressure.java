package com.mycompany.myapp.dto;

import java.util.Date;

public class Pressure {

	private int prno;
	private Date prtime;
	private double pressure;

	public int getPrno() {
		return prno;
	}

	public void setPrno(int pno) {
		this.prno = pno;
	}

	public Date getPrtime() {
		return prtime;
	}

	public void setPrtime(Date ptime) {
		this.prtime = ptime;
	}

	public double getPressure() {
		return pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

}
