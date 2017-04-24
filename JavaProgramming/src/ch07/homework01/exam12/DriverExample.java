package ch07.homework01.exam12;

public class DriverExample {

	public static void main(String[] args) {
		Driver driver=new Driver();
		
		Bus bus = new Bus();
		Taxi taxi=new Taxi();
		
		driver.drive(bus);
		driver.drive(taxi);
	}

}
