package ch06.homework01;

public class Car7 {
	//Field
	String model;
	int speed;
	
	//Constructor
	//this를 통해 매개변수 필드값을 구분
	Car7(String model){
		this.model=model;
	}
	
	//Method
	//this를 통해 매개변수와 필드값을 구분
	void setSpeed(int speed){
		this.speed=speed;
	}
	
	void run(){
		for(int i=10; i<=50; i+=10){
			//this를 이용하여 현재 클래스의 메소드 명시
			this.setSpeed(i);;
			//this를 통해 현재 클래스 필드값 명시
			System.out.println(this.model +"가 달립니다.(시속:"+this.speed+"km/h)");
		}
	}
}
