package ch09.exam05;

public class Example {

	public static void main(String[] args) {
		A a = new A();
		A.B b = a.new B();
		A.C c = new A.C(); //static class이기 때문에 A 생성 없이도 사용 가능하다.
	}

}
