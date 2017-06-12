package ch05.homework01;

public class IfExample {

	public static void main(String[] args) {
		int score =93; 
		
		//score가 90이상이면 실행 아니면 통과
		if(score>=90){	
			System.out.println("점수가 90보다 큽니다.");
			System.out.println("등급은 A입니다.");
		}
		
		//score가 90미만이면 실행 아니면 통과
		if(score<90)	
			System.out.println("점수가 90보다 작습니다.");
			
		System.out.println("등급은 B입니다.");	//if문과 상관없이 실행되는 부분
		
	}

}
