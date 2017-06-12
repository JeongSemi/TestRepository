package ch06.homework02;

public class Arm {
	String location;
	int checkNum=2;

	Arm(String location){
		this.location=location;
	}
	
	void move(int num){
		switch(num){
		case 1: 
			if(checkNum==1){
				System.out.println("이미 팔을 들고있습니다.");
			}else{
				System.out.println(location+"팔을 들었습니다.");
				checkNum=1;
			}
			break;
		case 2:
			if(checkNum==2){
				System.out.println("이미 팔을 내리고 있습니다.");
			}else{
				System.out.println(location+"팔을 내렸습니다.");
				checkNum=2;
			}
			
			break;
		}
	}
}
