package ch06.homework03.exam01;

public class CalculatorExample {

	public static void main(String[] args) {
		//pi값은 static이므로 객체생성 안하고 사용가능
		double result1=10*10*Calculator.pi;
		//plus메소드는 static이므로 객체 생성 안하고 사용가능
		int result2=Calculator.plus(10, 5);
		//minus메소드는 static이므로 객체 생성 안하고 사용가능
		int result3=Calculator.minus(10, 5);
		
		System.out.println("result1:"+result1);
		System.out.println("result2:"+result2);
		System.out.println("result3:"+result3);
	}

}
