package ch06.homework02;

public class Power {
	//Field
	
	//Constructor
	
	//Method
	void start() throws Exception{
		int power=0;
		while(power!=10){
			power=System.in.read();
		}
		System.out.println("전원이 켜졌습니다.");
	}
	void stop() {
		System.out.println("전원이 꺼집니다.");
		System.exit(0);
	}
}
