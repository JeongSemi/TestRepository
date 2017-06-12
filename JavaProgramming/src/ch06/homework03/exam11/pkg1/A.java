package ch06.homework03.exam11.pkg1;	//B클래스와 패키지가 같다. 

//default 접근제한
public class A {
	//Field
	public int field1; 	//public 접근 제한
	int field2;			//default 접근 제한
	private int field3;	//private 접근 제한
	
	//Constructor
	public A(){
		field1=1;
		field2=1;		//호출하면 내부에서 사용하므로 영향을 받지 않는다. 
		field3=1;
		
		method1();
		method2();
		method3();
	}
	
	//Method
	public void method1(){			//public 접근 제한
		
	}
	void method2(){					//default 접근제한
		
	}
	
	private void method3(){			//private 접근제한
		
	}
	
	
}
