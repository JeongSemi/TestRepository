package ch06.homework03.exam09.pkg2;//A와 B와 패키지가 다르다

import ch06.homework03.exam09.pkg1.*;

public class C {
	//A a;	default이므로 다른 패키지에서 접근이 불가능 하다. 
	B b;	//public이므로 다른 패키지에서 접근이 가능하다. 
	
}
