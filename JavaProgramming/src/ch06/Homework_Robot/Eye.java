package ch06.Homework_Robot;

public class Eye {
	//Field
	String direction;
	
	//Constructor
	Eye(String direction){
		this.direction = direction;
	}
	
	//Method
	void lightOn(){
		System.out.println(direction + "´«ÀÇ ºÒÀÌ ÄÑÁü");
	}
	void lightOff(){
		System.out.println(direction + "´«ÀÇ ºÒÀÌ ²¨Áü");
	}
	
	
}
