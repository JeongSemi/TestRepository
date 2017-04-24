package ch05.homework01;

public class BreakExample {

	public static void main(String[] args) {
		while(true){
			int num=(int)(Math.random()*6)+1;	//1~6까지 랜덤 수 생성
			System.out.println(num);
			//랜덤으로 나온 수가 6이면 프로그램 종료;
			if(num==6){
				break;
			}
		}
		System.out.println("프로그램 종료");
	}

}
