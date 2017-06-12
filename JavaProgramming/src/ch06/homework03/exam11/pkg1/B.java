package ch06.homework03.exam11.pkg1;//A와 패키지가 같다. 

public class B {
	public B(){
		A a=new A();
		a.field1=1;	//public이므로 접근 가능
		a.field2=1;	//같은 패키지 이므로 default 접근 가능
		//a.field3=1;	//private이므로 같은 패키지 여도 접근 불가능
		
		a.method1();	//public이므로 접근 가능
		a.method2();	//같은 패키지 이므로 default 접근 가능
		//a.method3();	//private이므로 같은 패키지 여도 접근 불가능
	}
}
