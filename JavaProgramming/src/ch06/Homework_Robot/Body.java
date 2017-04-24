package ch06.Homework_Robot;

public class Body {
	//Field
	String location;
	//Constructor
	//Method
	void bend(){
		System.out.println("허리를 구부림");
	}
	void stretch(){
		System.out.println("똑바로 섬");
	}
	
	void turnBody(String direction){
		System.out.println(direction + "으로 몸을 돌림");
	}
	
	void turnBack(){
		System.out.println("뒤로 돈다");
	}
}
