package ch09.exam07;

public class Example2 {

	public static void main(String[] args) {
		//로컬 클래스를 정의하고 객체 생성
		/*
		class CImpl implements A.C {
			public void cMethod() {
				System.out.println("CImple-cMethod()");
			}
		}
		*/
		A.C c = new A.C() {
			public void cMethod() {
				System.out.println("CImple-cMethod()");
			}
		};
		c.cMethod();
	}

}
