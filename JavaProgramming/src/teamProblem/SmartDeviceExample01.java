package teamProblem;

public class SmartDeviceExample01 {

	public static void main(String[] args) {
	
		SmartDevice.Phone phone = new SmartDevice.Phone() {
			@Override
			void text() {
				System.out.println("���ں�����.");		
			}
		};
		phone.text();
	}

}