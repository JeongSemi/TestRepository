package ch06.homework03.exam12;

public class CarExample {

	public static void main(String[] args) {
		Car myCar = new Car();
		
		//잘못된 속도 변경
		myCar.setSpeed(-50);
		
		System.out.println("현재속도:"+myCar.getSpeed());
		
		//올바른 속도 변경
		myCar.setSpeed(60);
		
		//차가 달리고 있으면 멈추게 하는 코드
		if(!myCar.isStop()){
			myCar.setStop(true);
		}
		
		//멈췄기 때문에 속도는 0
		System.out.println("현재속도:"+myCar.getSpeed());
	}

}
