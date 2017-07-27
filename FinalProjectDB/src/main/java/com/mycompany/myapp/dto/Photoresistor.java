package com.mycompany.myapp.dto;

import java.util.Date;

public class Photoresistor {

	private int phno;
	private Date phtime;
	private double photoresistor;

	public int getPhno() {
		return phno;
	}

	public void setPhno(int phno) {
		this.phno = phno;
	}

	public Date getPhtime() {
		return phtime;
	}

	public void setPhtime(Date phtime) {
		this.phtime = phtime;
	}

	public double getPhotoresistor() {
		return photoresistor;
	}

	public void setPhotoresistor(double photoresistor) {
		this.photoresistor = photoresistor;
	}

}
