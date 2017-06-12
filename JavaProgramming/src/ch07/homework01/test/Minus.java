package ch07.homework01.test;

public class Minus extends Calc{
	public Minus(int num1, int num2){
		super(num1, num2);
	}
	
	@Override
	public int method() {
		return this.num1-this.num2;
	}
}
