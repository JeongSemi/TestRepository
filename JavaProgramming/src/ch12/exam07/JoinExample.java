package ch12.exam07;

public class JoinExample {

	public static void main(String[] args) {

		SumThread thread = new SumThread();
		thread.start();

		try {
			thread.join(); // ������ ����������(run�޼ҵ尡 ����������) ��ٸ��ڴ�
		} catch (InterruptedException e) {	}
		long result = thread.getSum();
		System.out.println(result);
	}

}
