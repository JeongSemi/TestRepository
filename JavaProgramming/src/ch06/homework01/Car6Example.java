package ch06.homework01;

public class Car6Example {

	public static void main(String[] args) {
		Car6 myCar =new Car6();
		//keyTurnOn 메소드 호출
		myCar.keyTurnOn();
		//run 메소드 호출
		myCar.run();
		//getSpeed 메소드 호출후 리턴값 변수에 저장
		int speed = myCar.getSpeed();
		System.out.println("현재속도: "+speed+"km/h");
	}

}
