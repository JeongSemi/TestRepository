package ch06.Homework_Robot;

public class Body {
	//Field
	String location;
	//Constructor
	//Method
	void bend(){
		System.out.println("�㸮�� ���θ�");
	}
	void stretch(){
		System.out.println("�ȹٷ� ��");
	}
	
	void turnBody(String direction){
		System.out.println(direction + "���� ���� ����");
	}
	
	void turnBack(){
		System.out.println("�ڷ� ����");
	}
}
