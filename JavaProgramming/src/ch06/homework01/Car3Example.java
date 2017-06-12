package ch06.homework01;

public class Car3Example {

	public static void main(String[] args) {
		//첫번째 생성자 이용해서 객체 생성, 매개변수 하나도 없음
		Car3 car1=new Car3();
		System.out.println("car1.company:"+car1.company);
		System.out.println();
	
		//2번째 생성자 이용해서 객체 생성, 매개변수 1개
		Car3 car2=new Car3("자가용");
		System.out.println("car2.company:"+car2.company);
		System.out.println("car2.model:"+car2.model);
		System.out.println();
		
		//3번째 생성자 이용해서 객체 생성, 매개변수 2개
		Car3 car3=new Car3("자가용", "빨강");
		System.out.println("car3.company:"+car3.company);
		System.out.println("car3.model:"+car3.model);
		System.out.println("car3.color:"+car3.color);
		System.out.println();
		
		//4번째 생성자 이용해서 객체 생성, 매개변수 3개
		Car3 car4=new Car3("택시", "검정", 200);
		System.out.println("car4.company:"+car4.company);
		System.out.println("car4.model:"+car4.model);
		System.out.println("car4.color:"+car4.color);
		System.out.println("car4.maxSpeed:"+car4.maxSpeed);
	}

}
