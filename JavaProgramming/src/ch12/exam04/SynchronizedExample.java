package ch12.exam04;

public class SynchronizedExample {

	public static void main(String[] args) {
		Calculator calc = new Calculator();

		User1 user1 = new User1();
		user1.setCalculator(calc);
		user1.start();

		User2 user2 = new User2();
		user2.setCalculator(calc);
		user2.start(); // synchronized ������ �ʾ��� �� : user1�� �����ϴµ��� user2�� �����ؼ�
						// memory���� 50���� ������(calc��ü ����)
		// calc��ü�� �޼ҵ忡 synchronized�� ���̸� user1 ���� �� user2 ����
	}

}
