package ch06.homework03.exam02;

public class Television {
	static String company ="Samsung";
	static String model="LCD";
	static String info;
	//static인 info 계산하여 초기값 생성
	static{
		info=company+"-"+model;
	}
}
