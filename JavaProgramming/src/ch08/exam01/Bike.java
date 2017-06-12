package ch08.exam01;

public class Bike implements Manual{
	private int speed;
	
	
	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("전동자전거를 구동합니다.");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("전동자전거를 끕니다.");
	}

	@Override
	public void setSpeed(int speed) {
		// TODO Auto-generated method stub
		System.out.println("속도를"+speed+"로 변경합니다.");
		this.speed = speed;
	}

	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return speed;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("전동 자전거가 "+speed+"속도로 달립니다.");
	}
	
	
}
