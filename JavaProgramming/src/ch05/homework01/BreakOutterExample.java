package ch05.homework01;

public class BreakOutterExample {

	public static void main(String[] args) {
		//Outter 선언 및 A부터 Z까지 반복
		Outter: for(char upper='A'; upper<='Z'; upper++){
			//a부터 z까지 반복
			for(char lower='a'; lower<='z'; lower++){
				System.out.println(upper + "-"+lower);
				if(lower=='g'){
					//바로 앞 반복문이 아닌 Outer설정한 부분 반복문 종료 
					break Outter;
				}
			}
		}
		System.out.println("프로그램 실행 종료");
	}

}
