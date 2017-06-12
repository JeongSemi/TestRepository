package ch05.homework01;

public class SwitchCharExample {

	public static void main(String[] args) {
		char grade='B';
		
		//char일 경우도 스위치 가능
		switch(grade){
		//A또는 a일 경우
		case 'A':
		case 'a':
			System.out.println("우수회원입니다.");
			break;
		//B또는 b일 경우
		case 'B':
		case 'b':
			System.out.println("일반회원입니다.");
			break;
		//위의 조건과 아무것도 맞지 않을경우
		default:
			System.out.println("손님입니다.");
		}
	}

}
