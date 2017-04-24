package ch12.exam02;

import java.awt.Toolkit;

public class BeepPrintExample {

	public static void main(String[] args) {

		BeepThread beepThread = new BeepThread();

		beepThread.start();

		// 프린트를 하는 코드
		Thread printThread = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("띵");
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
