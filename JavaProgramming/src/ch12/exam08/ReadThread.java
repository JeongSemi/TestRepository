package ch12.exam08;

public class ReadThread extends Thread {

	// Field
	private DataBox dataBox; // 공유 객체 저장 필드

	// Constructor 대신 setter를 통해 추가 가능
	// 생성자 주입 / setter 주입
	public ReadThread(DataBox dataBox) {
		this.dataBox = dataBox;
	}

	// Method
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			String data = dataBox.getData();
		}
	}
}
