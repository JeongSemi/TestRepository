package ch07.homework01.test;

public class Plus extends Calc{
	public Plus(int num1, int num2){
		super(num1, num2);
	}
	
	@Override
	public int method() {
		return num1+num2;
	}
}
