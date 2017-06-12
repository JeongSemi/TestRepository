package ch06.exam01;

public class Car {
	//Field : 객체가 가져야할 데이터 부분
	String company="현대자동차";		//설계도 상에 고정할 필요는 없다. 바뀔수도 있다. 
	int speed;						//어떠한 값이 들어올지 모르면 비워둠
	String color;
	boolean airback;
	
	//Constructor
	Car(){
		//객체를 만들때 객체를 어떻게 만들어야 된다는 내용
		color="흰색";
		airback=true;
	}
	
	//Method
	void run(){
		System.out.println("현재 "+ speed + "km/h로 달립니다.");
	}
	
}
