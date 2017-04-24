package ch06.homework03.exam03;


public class Car {
		//인스턴스 필드
		int speed;
		//인스턴스 메소드 
		void run(){
			System.out.println(speed+"으로 달립니다.");
		}
		
		//main 메소드는 정적 메소드 이다. 
		public static void main(String[] args){
			//정적메소에서 인스턴스 필드와 메소드를 사용하기 위해서는 객체 생성후 사용해야 한다. 
			Car myCar=new Car();
			myCar.speed=60;
			myCar.run();
		}
}
