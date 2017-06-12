package ch05.homework01;

public class IfElseExample {

	public static void main(String[] args) {
		int score =85;
		
		//score가 90이상이면 실행되는 부분
		if(score>=90){
			System.out.println("점수가 90보다 큽니다.");
			System.out.println("등급은 A입니다.");
		}else{		//90미만이면 실행 되는 부분
			System.out.println("점수가 90보다 작습니다.");
			System.out.println("등급은 B입니다.");
		}
	}

}
