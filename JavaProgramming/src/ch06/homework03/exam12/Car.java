package ch06.homework03.exam12;

public class Car {
	//Field
	//private로 생성해서 접근이 불가능 하다. 
	private int speed;
	private boolean stop;
	
	//Constructor
	
	//Method
	//public 으로 해서 접근이 가능하다. 
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		if(speed <0){
			this.speed=0;
			return;
		}else{
			this.speed = speed;
		}
		
	}
	public boolean isStop() {
		return stop;
	}
	public void setStop(boolean stop) {
		this.stop = stop;
		this.speed=0;
	}

}
