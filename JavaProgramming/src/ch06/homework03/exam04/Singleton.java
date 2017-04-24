package ch06.homework03.exam04;

public class Singleton {
	//Field
	//객체 생성 정적영역에 생성하므로 바깥에서 new하지 않아도 객체 생성 , private로 접근 못하게 막음
	private static Singleton singleton=new Singleton();
	
	//Constructor
	//외부에서 생성자 호출 할수 없게 private
	private Singleton(){
		
	}
	
	//Method
	//메소드를 이용해서 객체 주소값을 가져갈수 있도록
	static Singleton getInstance(){
		return singleton;
	}
	
}
