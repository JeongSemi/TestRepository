package ch06.Homework_Robot;

public class Head {
	//Field
	Eye[] eyes = { new Eye("왼쪽"), new Eye("오른쪽") };
	Nose nose;
	Ear[] ears = { new Ear("왼쪽"), new Ear("오른쪽") };
	Mouth mouth;
	String direction;
	
	//Constructor
	
	//Method
	
	void turnHead(String direction){

		if(direction == "아래쪽")
			System.out.println("고개를 숙임");
		else if(direction == "위쪽")
			System.out.println("고개를 듬");
		else if(direction == "오른쪽" || direction == "왼쪽")
			System.out.println(direction + "으로 고개를 돌림");
		
	}
	
	void headFront(){
		System.out.println("정면을 바라봄");
	}
}
