package ch06.Homework_Robot;

public class Head {
	//Field
	Eye[] eyes = { new Eye("����"), new Eye("������") };
	Nose nose;
	Ear[] ears = { new Ear("����"), new Ear("������") };
	Mouth mouth;
	String direction;
	
	//Constructor
	
	//Method
	
	void turnHead(String direction){

		if(direction == "�Ʒ���")
			System.out.println("���� ����");
		else if(direction == "����")
			System.out.println("���� ��");
		else if(direction == "������" || direction == "����")
			System.out.println(direction + "���� ���� ����");
		
	}
	
	void headFront(){
		System.out.println("������ �ٶ�");
	}
}
