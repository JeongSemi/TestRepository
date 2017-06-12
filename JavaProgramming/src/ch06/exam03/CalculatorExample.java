package ch06.exam03;

public class CalculatorExample {

	public static void main(String[] args) {
		Calculator calc=new Calculator();
		
		calc.powerOn();
		
		String info=calc.info();
		System.out.println(info);
		
		int result1 = calc.plus(10, 20);
		System.out.println(result1);
		
		double result2 = calc.divide(10, 20);
		System.out.println(result2);
		
		int[] array=calc.changeArray(10, 20, 30);
		for(int a : array){
			System.out.print(a+" ");
		}
		System.out.println();
		
		Car makecar=calc.makeCar("»¡°­", true);
		System.out.println(makecar.color);
		System.out.println(makecar.color);
	}

}
