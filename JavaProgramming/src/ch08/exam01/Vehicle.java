package ch08.exam01;

public class Vehicle {
	//Field
	private Manual manual;
	//constructor
	Vehicle(Manual manual){
		this.manual=manual;
	}
	//Method
	public void move(){
		manual.turnOn();
		manual.setSpeed(10);
		manual.run();
		manual.turnOff();
	}
}
