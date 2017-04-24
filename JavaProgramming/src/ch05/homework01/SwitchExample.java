package ch05.homework01;

public class SwitchExample {

	public static void main(String[] args) {
		int num =(int)(Math.random()*6)+1;		//1부터 6까지 중 랜덤으로 숫자 생성
		
		//1~6까지 조건으로 출력
		switch(num){
		case 1:
			System.out.println("1번이 나왔습니다.");
			break;									//해당조건에서 종료
		case 2:
			System.out.println("2번이 나왔습니다.");
			break;									//해당조건에서 종료
		case 3:
			System.out.println("3번이 나왔습니다.");
			break;									//해당조건에서 종료
		case 4:
			System.out.println("4번이 나왔습니다.");
			break;									//해당조건에서 종료
		case 5:
			System.out.println("5번이 나왔습니다.");
			break;									//해당조건에서 종료
		default:									//위의 조건이 모두 아니면
			System.out.println("6번이 나왔습니다.");
			break;									//해당조건에서 종료
		}
	}

}
