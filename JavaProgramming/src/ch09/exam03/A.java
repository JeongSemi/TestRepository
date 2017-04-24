package ch09.exam03;

public class A {
	//Field
	//Constructor
	A(){
		int localVariable = 2;//로컬 클래스
		class D{
			//Field
			//Constructor
			//Method
			void dMethod(){
				int result = localVariable + 8;
				//localVariable = 10;
				System.out.println(result);
			}
		}
	}
	//Method
	void method(){
		//로컬 클래스
		class E{
			//Field
			//Constructor
			//Method
			void eMethod(){

			}
		}
	}
	
	//Nested Class 중첩 멤버 클래스
	class B{
		//Field
		//Constructor
		//Method
		void bMethod(){

		}
	}
	static class C{
		//Field
		//Constructor
		//Method
		void cMethod(){
			// aField = 10; static으로 선언된 field만 사용가능하다
		}
	}
	
}
