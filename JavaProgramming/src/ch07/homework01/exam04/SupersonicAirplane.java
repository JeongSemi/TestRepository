package ch07.homework01.exam04;

public class SupersonicAirplane extends Airplane{
	public static final int NORMAL=1;
	public static final int SUPERSONIC=2;
	
	public int flyMode=NORMAL;
	
	@Override
	public void fly() {
		if(flyMode == SUPERSONIC){
			System.out.println("초음속 비행기입닏다.");
		}else{
			super.fly();
		}
	}
}
