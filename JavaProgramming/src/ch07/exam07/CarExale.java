package ch07.exam07;

public class CarExale {

	public static void main(String[] args) {
		
		Car car = new Car(new SnowTire());
		car.run();
		
		car.setTire(new NormalTire());
		car.run();
		
		car.setTire(new SpeedTire());
		car.run();
		
		car.setTire(new ColorTire());
		car.run();
	}

}
