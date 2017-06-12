package ch07.homework01.exam06;

public class SportsCar extends Car{
	@Override
	public void speedUp() {
		speed+=10;
	}
	
	//stop은 나오지도 않음 final로써 오버라이딩 못함
}
