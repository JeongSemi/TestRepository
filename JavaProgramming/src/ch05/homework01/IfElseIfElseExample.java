package ch05.homework01;

public class IfElseIfElseExample {

	public static void main(String[] args) {
		int score =75;
		
		//90이상이면 실행되는 부분
		if(score>=90){
			System.out.println("점수가 100~90입니다.");
			System.out.println("등급은 A입니다.");
		}else if(score>=80){	//80이상이면 실행되는 부분
			System.out.println("점수가 80~89 입니다.");
			System.out.println("등급은 B입니다.");
		}else if(score>=70){	//70이상이면 실행되는 부분
			System.out.println("점수가 70~79 입니다.");
			System.out.println("등급은 C입니다.");
		}else{					//70미만일 경우 실행되는 부분
			System.out.println("점수가 70미만 입니다.");
			System.out.println("등급은 D입니다.");
		}
	}

}
