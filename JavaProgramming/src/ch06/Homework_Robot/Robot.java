package ch06.Homework_Robot;

public class Robot {
	//Field
	Head head = new Head();
	Arm[] arms = { new Arm("왼쪽"), new Arm("오른쪽") };
	Leg legs = new Leg();
	Body body = new Body();
	String date;
	String name;
	
	//Constructor
	Robot(String date, String name){
		this.date = date;
		this.name = name;
	}
		
	//Method
	
}
