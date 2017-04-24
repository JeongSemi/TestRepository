package ch05.exam01;	//패키지 

public class TypeExmaple01 {		//메인 메소드가 없기 때문에 실행이 안됨
	public static void main(String[] args){
		System.out.println("main() method run ...");
		//기본타입
		//정수형
		byte v1 = 10; 
		char v2 = 'A';
		short v3 = 10;
		int v4 = 10;	//자바 정수 기본 타입
		long v5 = 10L; //확실히 long형이면 L붙여준다(8바이트로 계산).
		
		//실수형
		float v6 = 10.0f;	//코드상에서 f자 붙어있으면 4바이트로 해석
		double v7 = 10.0;	//없으면 8바이트, 자바 실수 기본 타입
		
		//bool형
		boolean v8 = true;
		
		//참조타입
		String name = "JAVA";	//값이 저장되는 것이 아닌 주소값이 저장됨 , 값은 힙영역에 저장
		int[] scores = {90,80,85};	//배열도 참조타입이다
	}
}
