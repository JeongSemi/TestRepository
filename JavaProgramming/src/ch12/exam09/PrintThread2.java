package ch12.exam09;

public class PrintThread2 extends Thread {
	// Field
	// Constructor
	// Method
	public void run() {
		try {
			while (true) {
				System.out.println("���� ��...");
				System.out.println("���� ��...");
				// Thread.sleep(1);
				if (isInterrupted()) { // interrupted �޼ҵ尡 ȣ��Ǹ� true!
					// -> try catch ��ü�� �ʿ������
					// Thread.interrupted()�� �ᵵ ����
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("�ڿ� ����");
			System.out.println("���� ����");
		}
	}

}
