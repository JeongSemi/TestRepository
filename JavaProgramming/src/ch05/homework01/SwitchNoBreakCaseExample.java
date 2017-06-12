package ch05.homework01;

public class SwitchNoBreakCaseExample {

	public static void main(String[] args) {
		int time =(int)(Math.random()*4)+8;		//8에서 11까지 수중 랜덤으로 생성
		System.out.println("[현재시간: "+ time + " 시");
		
		//break가 없으므로 해당되는 케이스의 아래 모두 실행
		switch(time){
		case 8:
			System.out.println("출근합니다.");
		case 9:
			System.out.println("회의를 합니다.");
		case 10:
			System.out.println("업무를 봅니다.");
		default:
			System.out.println("외근을 나갑니다.");
		}
		
	}

}
