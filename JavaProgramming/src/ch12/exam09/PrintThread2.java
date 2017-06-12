package ch12.exam09;

public class PrintThread2 extends Thread {
	// Field
	// Constructor
	// Method
	public void run() {
		try {
			while (true) {
				System.out.println("실행 중...");
				System.out.println("실행 중...");
				// Thread.sleep(1);
				if (isInterrupted()) { // interrupted 메소드가 호출되면 true!
					// -> try catch 자체가 필요없을듯
					// Thread.interrupted()를 써도 좋다
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("자원 정리");
			System.out.println("실행 종료");
		}
	}

}
