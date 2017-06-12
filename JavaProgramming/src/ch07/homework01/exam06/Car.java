package ch07.homework01.exam06;

public class Car {
	public int speed;
	
	public void speedUp() { speed+=1;}
	
	public final void stop(){
		System.out.println("Â÷¸¦ ¸ØÃã");
		speed=0;
	}
}
