package ch06.homework01;

public class Car4 {
	//Field
	String company="현대자동차";
	String model;
	String color;
	int maxSpeed;
	
	//Construct
	//생성자 오버로딩
	//매개변수 0개
	Car4(){
		
	}
	//매개변수 3개짜리 생성자 호출
	Car4(String model){
		this(model, "은색", 250);
	}
	
	//매개변수 3개짜리 생성자 호출
	Car4(String model, String color){
		this(model, color, 250);
	}
	
	Car4(String model, String color, int maxSpeed){
		//공통 실행 콛드
		this.model=model;
		this.color=color;
		this.maxSpeed=maxSpeed;
	}
}
