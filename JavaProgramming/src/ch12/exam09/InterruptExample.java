package ch12.exam09;

public class InterruptExample {

	public static void main(String[] args) {

		PrintThread2 thread2 = new PrintThread2();
		thread2.start();
		try {	Thread.sleep(2000);	} catch (Exception e) {	} 
		thread2.interrupt(); // 일시정지일 때만 영향을 받는다. (예외발생)
	}

}
