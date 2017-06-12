package ch06.homework03.exam10.pkg1;	//B클래스와 패키지가 같다. 

//default 접근제한
public class A {
	//Field
	//모두 접근 가능
	A a1= new A(true);
	A a2=new A(1);
	A a3=new A("문자열");
	
	//Constructor
	//생성자 오버로딩
	//퍼블릭
	public A(boolean b){
		
	}
	//default
	A(int b){
		
	}
	//private
	private A(String s){
		
	}
}
