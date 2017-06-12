package ch05.exam03;

public class ReadKeyCodeExample {

	public static void main(String[] args) throws Exception {
		System.out.println("----------------------------");
		System.out.println("1. 저장 | 2. 읽기 | 3. 종료");
		System.out.println("----------------------------");
		
		//int keycode=0;
		while(true){
			int keycode=0;
			if(keycode!=13&&keycode!=10){
				System.out.print("번호선택:");
			}
			keycode =System.in.read();
			//System.out.println(keycode);
			switch(keycode){
			case 49:
				System.out.println("저장선택");
				break;
			case 50:
				System.out.println("읽기선택");
				break;
			case 51:
				System.out.println("종료선택");
				//return;		//main을 종료함으로써 종료 
				System.exit(0);		//jvm종료시킴 
			}
		}
		
	}

}
