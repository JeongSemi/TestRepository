package ch09.exam03;

public class A {
	//Field
	//Constructor
	A(){
		int localVariable = 2;//���� Ŭ����
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
		//���� Ŭ����
		class E{
			//Field
			//Constructor
			//Method
			void eMethod(){

			}
		}
	}
	
	//Nested Class ��ø ��� Ŭ����
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
			// aField = 10; static���� ����� field�� ��밡���ϴ�
		}
	}
	
}
