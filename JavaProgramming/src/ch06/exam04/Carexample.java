package ch06.exam04;


public class Carexample {

	public static void main(String[] args) {
		//객체 생성
		Car myCar = new Car("2017-03-28", "검정");
		//엔진 메소드 작동
		myCar.engine.start();
		myCar.engine.stop();
		//Dashboard의 메소드 호출
		myCar.dashboard.display(60);
		//타이어의 필드값 읽기 
		System.out.println(myCar.tires[0].location) ;
		//타이어의 메소드 호출
		myCar.tires[2].roll();
		//car의 메소드 호출
		myCar.start();
		myCar.run();
		myCar.stop();
		
		//-------------------------------------
		//Tire 부품교체 
		myCar.tires[0]=new Tire("새 앞1번 바퀴");
		myCar.run();
	}

}
