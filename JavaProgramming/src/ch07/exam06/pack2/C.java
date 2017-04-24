package ch07.exam06.pack2;

import ch07.exam06.pack1.A;

public class C {
	public void test() {
		A a = new A(); //상속받지 않았기 때문에 객체 생성해야 접근 가능
		a.field = 10 ;
		a.method();
	}

}
