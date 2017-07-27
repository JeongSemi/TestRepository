package com.mycompany.myapp.dto;

import java.util.Date;

public class Raindrop {

	private int rno;
	private Date rtime;
	private double rainvalue;

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public Date getRtime() {
		return rtime;
	}

	public void setRtime(Date rtime) {
		this.rtime = rtime;
	}

	public double getRainvalue() {
		return rainvalue;
	}

	public void setRainvalue(double rainvalue) {
		this.rainvalue = rainvalue;
	}

}
