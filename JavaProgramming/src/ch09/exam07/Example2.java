package ch09.exam07;

public class Example2 {

	public static void main(String[] args) {
		//���� Ŭ������ �����ϰ� ��ü ����
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
