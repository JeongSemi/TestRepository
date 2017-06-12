package ch07.homework01.test;

public class Run {
	private Calc calc;
	 
	
	public void setCalc(Calc calc){
		this.calc=calc;
	}
	
	public void run(){
		System.out.println(calc.method()); 
	}
}
