package ch06.Homework_Robot;

public class RobotExample {

	public static void main(String[] args) {
		//Robot 객체 생성
		Robot robot = new Robot("2017-03-28", "알파셈");
		
		//동작
		System.out.println("[인사]");
		robot.body.bend();
		robot.body.stretch();
		
		System.out.println("\n[오른쪽을 바라봅니다.]");
		robot.head.turnHead("오른쪽");
		
		System.out.println("\n[양쪽 눈의 불을 켭니다.]");
		robot.head.eyes[0].lightOn();
		robot.head.eyes[1].lightOn();
		
		System.out.println("\n[오른쪽을 가리킵니다.]");
		robot.arms[1].point(robot.arms[1].hand);
		
		System.out.println("\n[오른쪽의 물건을 줍겠습니다.]");
		robot.body.turnBody("오른쪽");
		robot.legs.walk();
		robot.legs.stop();
		robot.legs.bend();
		robot.head.turnHead("아래쪽");
		robot.arms[0].grab(robot.arms[0].hand);
		
		System.out.println("\n[주웠습니다.]");	
		System.out.println("[제자리로 돌아오기 위해 준비합니다.]");
		robot.head.headFront();
		robot.legs.stretch();
		robot.body.turnBack();
		
		System.out.println("\n[왼쪽으로 뛰어가겠습니다.]");
		robot.head.turnHead("왼쪽");
		robot.body.turnBody("왼쪽");
		robot.legs.run();
		
		System.out.println("\n[장애물을 만났습니다.]");
		robot.legs.stop();
		robot.legs.jump();
		robot.legs.run();
		
		System.out.println("\n[도착했습니다.]");
		robot.legs.stop();
		robot.arms[0].hand.stretch();
		robot.head.eyes[0].lightOff();
		robot.head.eyes[1].lightOff();
		
		System.out.println("\n[안녕~]");
		robot.arms[1].wave();
	}

}
