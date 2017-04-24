package ch06.exam07;

public class Calculator {
	//Field
	static String model ="MI-94";
	static String makeDay="2017-03-29";
	static String info; //MI-94(2017-03-29)
	
	//static block
	static{
		info=model;
		info+="(";
		info+=makeDay;
		info+=")";
	}
	//Method
	
}
