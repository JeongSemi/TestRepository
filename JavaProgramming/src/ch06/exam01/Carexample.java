package ch06.exam01;

public class Carexample {

	public static void main(String[] args) {
		//객체 생성코드
		Car mycar=new Car();
		
		//객체 메소드 호출
		mycar.run();
		
		//객체의 필드를 읽기 
		System.out.println(mycar.company);
		System.out.println(mycar.speed);
		System.out.println(mycar.color);
		System.out.println(mycar.airback);
		
		//객체의 필드값을 변경
		mycar.speed=30;
		mycar.color="흰색";
		mycar.run();
		System.out.println(mycar.speed);
		System.out.print(mycar.color);
		
		//-------------------------------------
		
		Car yourcar = new Car();
		System.out.println(yourcar.company);
		System.out.print(yourcar.airback);
		System.out.println(yourcar.speed);
		System.out.print(yourcar.color);
	}
	
	public static void test(Car mycar){
		System.out.println(mycar);
	}

}
