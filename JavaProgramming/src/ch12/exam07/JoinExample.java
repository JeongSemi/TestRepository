package ch12.exam07;

public class JoinExample {

	public static void main(String[] args) {

		SumThread thread = new SumThread();
		thread.start();

		try {
			thread.join(); // 실행이 끝날때까지(run메소드가 끝날때까지) 기다리겠다
		} catch (InterruptedException e) {	}
		long result = thread.getSum();
		System.out.println(result);
	}

}
