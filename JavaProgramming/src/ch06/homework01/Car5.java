package ch06.homework01;

public class Car5 {
	//Field
	int gas;
	
	//Constructor
	
	//Method
	//매개값을 받아서 gas필드값 수정
	void setGas(int gas){
		this.gas=gas;
	}
	
	//가스 값 비교 후 특정 출력 및 리턴값 반환
	boolean isLeftGas(){
		if(gas==0){
			System.out.println("gas가 없습니다.");
			return false;
		}
		System.out.println("가스가 있습니다.");
		return true;
	}
	
	//가스가 있으면 달리고 가스 감소 
	void run(){
		while(true){
			if(gas >0){
				System.out.println("달립니다. (gas잔량:"+gas+")");
				gas-=1;
			}else{
				System.out.println("멈춥니다.(gas잔량:"+gas+")");
				return; //메소드 종료
			}
		}
	}
}
