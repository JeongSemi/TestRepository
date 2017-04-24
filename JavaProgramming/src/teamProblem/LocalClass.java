package teamProblem;

public class LocalClass {
	void method1(int arg1) {
		int field1 = 10;
		class A {
			int fieldA = 40;
			void methodA(int argA) {
				//field = 10;
				//field1 = 20;
				//field2 = 30;
				//arg = 500;
				//arg1 = 100;
				int result = arg1 + argA;
				System.out.println(result);
			}
			
			A a = new A();
		}
	}
}
