package ch06.homework01;

public class Calculator {
	//Field
	
	//Constructor
	
	//Method
	//반환형 없음, 매개변수 없음
	void powerOn(){
		System.out.println("전원을 켭니다.");
	}
	
	//int 반환형 int 매개변수
	int plus(int x, int y){
		int result=x+y;
		return result;
	}
	
	//double 반환형 
	double divide(int x, int y){
		//double에 넣기 위해서 int를 double로 형변환
		double result =(double)x/(double)y;
		//double형 반환
		return result;
	}
	
	//반환형 없음, 매개변수 없음
	void powerOff(){
		System.out.println("전원을 끕니다");
	}
	
}
