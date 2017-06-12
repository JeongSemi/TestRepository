package ch05.homework01;

public class WhileKeyControlExample{

	public static void main(String[] args) throws Exception{
		boolean run = true; 	//종료를 위한 변수 선언
		int speed =0;
		int keyCode=0;
		
		while(run){
			//엔터의 경우 제외 
			if(keyCode!=13&&keyCode!=10){
				System.out.println("------------------------");
				System.out.println("1.증속 | 2.감속 | 3.중지");
				System.out.println("------------------------");
				System.out.print("선택 :");
			}
			
			//키보드로 입력 받기 
			keyCode=System.in.read();
			
			//1입력했을시 
			if(keyCode ==49){
				speed++;
				System.out.println("현재속도="+speed);
			}else if(keyCode==50){		//2입력했을시
				speed--;
				System.out.println("현재속도="+speed);
			}else if(keyCode==51){		//3입력했을시
				run=false;				//while문 종료를 위해
			}
		}
		
		System.out.println("프로그램종료");
	}

}
