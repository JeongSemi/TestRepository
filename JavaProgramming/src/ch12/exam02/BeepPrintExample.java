package ch12.exam02;

import java.awt.Toolkit;

public class BeepPrintExample {

	public static void main(String[] args) {

		BeepThread beepThread = new BeepThread();

		beepThread.start();

		// ����Ʈ�� �ϴ� �ڵ�
		Thread printThread = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("��");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {

					}
				}
			}
		};

		printThread.start();
	}

}
