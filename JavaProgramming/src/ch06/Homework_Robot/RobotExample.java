package ch06.Homework_Robot;

public class RobotExample {

	public static void main(String[] args) {
		//Robot ��ü ����
		Robot robot = new Robot("2017-03-28", "���ļ�");
		
		//����
		System.out.println("[�λ�]");
		robot.body.bend();
		robot.body.stretch();
		
		System.out.println("\n[�������� �ٶ󺾴ϴ�.]");
		robot.head.turnHead("������");
		
		System.out.println("\n[���� ���� ���� �մϴ�.]");
		robot.head.eyes[0].lightOn();
		robot.head.eyes[1].lightOn();
		
		System.out.println("\n[�������� ����ŵ�ϴ�.]");
		robot.arms[1].point(robot.arms[1].hand);
		
		System.out.println("\n[�������� ������ �ݰڽ��ϴ�.]");
		robot.body.turnBody("������");
		robot.legs.walk();
		robot.legs.stop();
		robot.legs.bend();
		robot.head.turnHead("�Ʒ���");
		robot.arms[0].grab(robot.arms[0].hand);
		
		System.out.println("\n[�ֿ����ϴ�.]");	
		System.out.println("[���ڸ��� ���ƿ��� ���� �غ��մϴ�.]");
		robot.head.headFront();
		robot.legs.stretch();
		robot.body.turnBack();
		
		System.out.println("\n[�������� �پ�ڽ��ϴ�.]");
		robot.head.turnHead("����");
		robot.body.turnBody("����");
		robot.legs.run();
		
		System.out.println("\n[��ֹ��� �������ϴ�.]");
		robot.legs.stop();
		robot.legs.jump();
		robot.legs.run();
		
		System.out.println("\n[�����߽��ϴ�.]");
		robot.legs.stop();
		robot.arms[0].hand.stretch();
		robot.head.eyes[0].lightOff();
		robot.head.eyes[1].lightOff();
		
		System.out.println("\n[�ȳ�~]");
		robot.arms[1].wave();
	}

}
