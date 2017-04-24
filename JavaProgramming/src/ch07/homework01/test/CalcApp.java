package ch07.homework01.test;

public class CalcApp {

	public static void main(String[] args) {
		Run run=new Run();
		
		run.setCalc(new Plus(1,2));
		run.run();
		
		run.setCalc(new Minus(5,4));
		run.run();
	}

}
