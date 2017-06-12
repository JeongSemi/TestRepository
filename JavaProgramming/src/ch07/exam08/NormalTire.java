package ch07.exam08;

public class NormalTire extends Tire {
	//F
	
	//C
	NormalTire(){
		super();
		System.out.println("NormalTire 객체 생성");
	}
	//Method
	@Override
	void roll() {
		System.out.println("일반 타이어가 굴러갑니다.");
	}
}
