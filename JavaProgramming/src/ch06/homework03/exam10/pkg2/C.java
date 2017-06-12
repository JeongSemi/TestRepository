package ch06.homework03.exam10.pkg2;//A와 B와 패키지가 다르다

import ch06.homework03.exam10.pkg1.A;

public class C {
	A a1 =new A(true);	//public 이므로 접근 가능
	//A a2 = new A(1);	//default이기 때문에 다른 패키지에서 접근 불가능
	//A a3 = new A("문자열");	//private이기 때문에 해당 클래스에서만 접근 가능
	
}
