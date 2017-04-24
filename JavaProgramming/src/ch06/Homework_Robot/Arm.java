package ch06.Homework_Robot;

public class Arm {
	//Field
	Hand hand;
	String direction;
	
	//Constructor
	Arm(String direction){
		this.direction = direction;
		this.hand = new Hand();
	}
	
	//Method
	void bend(){
		System.out.println(direction + " ∆»¿ª ±∏∫Œ∏≤");
	}
	void point(Hand hand){
		System.out.print(direction);
		hand.point();
	}
	void grab(Hand hand){
		System.out.print(direction);		
		hand.grab();
	}
	void clap(){
		System.out.print(direction);
		hand.clap();
	}
	void wave(){
		System.out.print(direction);
		hand.wave();
	}
}
