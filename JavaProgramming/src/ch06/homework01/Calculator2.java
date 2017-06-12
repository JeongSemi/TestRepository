package ch06.homework01;

public class Calculator2 {
	//Field
	
	//Constructor
		
	//Method
	//int 반환형 int 매개변수
	int plus(int x, int y){
		int result=x+y;
		return result;
	}
	
	//double 반환형 
	double avg(int x, int y){
		//위에 선언한 plus메소드 호출
		double sum = plus(x,y);
		double result =sum/2;
		return result;
	}
	
	void execute(){
		//위에 선언한 avg메소드 호출 ->plus메소드 호출
		double result = avg(7,10);
		//밑에 선언한 println 메소드 호출
		println("실행결과 : "+result);
	}
	
	void println(String message){
		System.out.println(message);
	}
}
