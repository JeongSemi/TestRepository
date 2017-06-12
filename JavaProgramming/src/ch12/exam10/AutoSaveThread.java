package ch12.exam10;

public class AutoSaveThread extends Thread {
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000); // 1초마다
			} catch (InterruptedException e) {
			}
			save();
		}
	}

	public void save() {
		System.out.println("작업 내용을 저장함");
	}
}
