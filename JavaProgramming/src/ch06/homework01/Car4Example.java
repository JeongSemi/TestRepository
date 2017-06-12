package ch06.homework01;

public class Car4Example {

	public static void main(String[] args) {
		Car4 car1=new Car4();
		System.out.println("car1.company:"+car1.company);
		System.out.println();
	
		//2번째 생성자 이용해서 객체 생성, 매개변수 1개->결국 매개변수 3개짜리 생성자 돔
		Car4 car2=new Car4("자가용");
		System.out.println("car2.company:"+car2.company);
		System.out.println("car2.model:"+car2.model);
		System.out.println();
		
		//3번째 생성자 이용해서 객체 생성, 매개변수 2개->결국 매개변수 3개짜리 생성자 돔
		Car4 car3=new Car4("자가용", "빨강");
		System.out.println("car3.company:"+car3.company);
		System.out.println("car3.model:"+car3.model);
		System.out.println("car3.color:"+car3.color);
		System.out.println();
		
		//4번째 생성자 이용해서 객체 생성, 매개변수 3개
		Car4 car4=new Car4("택시", "검정", 200);
		System.out.println("car4.company:"+car4.company);
		System.out.println("car4.model:"+car4.model);
		System.out.println("car4.color:"+car4.color);
		System.out.println("car4.maxSpeed:"+car4.maxSpeed);
	}

}
