package ch06.homework02;

import java.util.Scanner;

public class Robot {
	//Field
	Arm[] arm={new Arm("오른쪽"), new Arm("왼쪽")};
	Head head=new Head();
	Leg[] leg={new Leg("오른쪽"), new Leg("왼쪽")};
	Power power= new Power();
	
	String maker="Lee Jung Soo";
	String color;
	String name;
	
	//Constructor
	Robot(){
		this("Black","JSBot");
	}
	
	Robot(String name){
		this("Black", name);
	}
	
	Robot(String color, String name){
		this.color=color;
		this.name=name;
		System.out.println(name+"로봇이 생성되었습니다.");
		System.out.println("이름 :"+name);
		System.out.println("색상 :"+color);
		System.out.println("제조자 :"+maker);
		System.out.println("------------------------------");
		System.out.print("엔터를 누르면 전원이 들어옵니다.>");
	}
	
	//Method
	void powerOn() throws Exception{
		power.start();
	}
	
	void walk(){
		Scanner scanner=new Scanner(System.in);
		head.mouth.ask("걸어갈 발자국 수를 입력하세요:");
		int num=scanner.nextInt();
		for(int i=0; i<num; i++){
			leg[0].move();
			leg[1].move();
		}
		head.mouth.tell("걸음을 모두 옯겨 멈췄습니다.");
		
		
	}
	
	void powerOff(){
		power.stop();
	}
	
	void seat(){
		leg[0].bend();
		leg[1].bend();
	}
	
	void stand(){
		leg[0].strech();
		leg[1].strech();
	}
	
}
