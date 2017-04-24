package ch06.homework01;

public class CalculatorExample {

	public static void main(String[] args) {
		//객체 생성
		Calculator myCalc= new Calculator();
		
		//powerOn메소드 호풀
		myCalc.powerOn();
		
		//plus메소드 호출
		int result1 =myCalc.plus(5, 6);
		System.out.println("result1: " + result1);
		
		byte x =10;
		byte y = 4;
		
		//debide메소드 출력
		double result2= myCalc.divide(x,  y);
		System.out.println("result2:"+result2);
		
		myCalc.powerOff();
	}

}
