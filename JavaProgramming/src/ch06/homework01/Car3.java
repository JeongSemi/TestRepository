package ch06.homework01;

public class Car3 {
	//Field
	String company="현대자동차";
	String model;
	String color;
	int maxSpeed;
	
	//생성자 오버로딩
	//매개변수 하나도 없음
	Car3(){
		
	}
	
	//매개변수 한개
	//this를 사용해서 매개변수와 필드값 구분
	Car3(String model){
		this.model=model;
	}
	
	//매개변수 두개
	//this를 사용해서 매개변수와 필드값 구분
	Car3(String model, String color){
		this.model=model;
		this.color=color;
	}
	
	//매개변수 새개
	//this를 사용해서 매개변수와 필드값 구분
	Car3(String model, String color, int maxSpeed){
		this.model=model;
		this.color=color;
		this.maxSpeed=maxSpeed;
	}
	
}
