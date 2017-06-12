package ch12.exam01;

import java.awt.Toolkit;

public class BeepPrintExample {

	public static void main(String[] args) {

		BeepTask beepTask = new BeepTask();
		Thread thread = new Thread(beepTask);

		thread.start();

		// 프린트를 하는 코드
		PrintTask printTask = new PrintTask();
		Thread thread2 = new Thread(printTask);
		
		//System.out.println(Thread.currentThread().getName());
		thread2.start();
	}

}
