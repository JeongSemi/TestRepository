package teamProblem;

public class SmartDeviceExample02 {
	public static void main(String[] args) {

		
		SmartDevice.Keyboard keyBoard = new SmartDevice.Keyboard() {
			
			@Override
			public void pressBtn() {
				System.out.println("��ư�� ���Ƚ��ϴ�.");				
				
			}
		};
		
		keyBoard.pressBtn();
		
	}
}
