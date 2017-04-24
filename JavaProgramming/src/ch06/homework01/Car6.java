package ch06.homework01;

public class Car6 {
	//Field
	int speed;
	
	//Constructor
	
	//Method
	//speed필드값 반환
	int getSpeed(){
		return speed;
	}
	
	
	void keyTurnOn(){
		System.out.println("키를 돌립니다.");
	}
	
	//시속 증가
	void run(){
		for(int i=10; i<=50; i+=10){
			speed=i;
			System.out.println("달립니다.(시속:" +speed + "km/h)");
		}
	}
	
}
