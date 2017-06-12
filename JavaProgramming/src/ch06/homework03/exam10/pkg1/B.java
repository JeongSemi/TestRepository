package ch06.homework03.exam10.pkg1;//A와 패키지가 같다. 

public class B {
	A a1=new A(true);	//public이므로 접근 가능
	A a2=new A(1); 	//default이어도 같은 패키지 이므로 접근 가능
	//A a3=new A("문자열");  private이므로 해당 클래스 내에서만 접근 가능
}
