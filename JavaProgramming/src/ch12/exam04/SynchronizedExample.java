package ch12.exam04;

public class SynchronizedExample {

	public static void main(String[] args) {
		Calculator calc = new Calculator();

		User1 user1 = new User1();
		user1.setCalculator(calc);
		user1.start();

		User2 user2 = new User2();
		user2.setCalculator(calc);
		user2.start(); // synchronized 붙이지 않았을 때 : user1이 실행하는동안 user2도 실행해서
						// memory값이 50으로 같아짐(calc객체 공유)
		// calc객체의 메소드에 synchronized를 붙이면 user1 실행 후 user2 실행
	}

}
