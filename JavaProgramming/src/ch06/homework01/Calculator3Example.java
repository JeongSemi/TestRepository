package ch06.homework01;

public class Calculator3Example {

	public static void main(String[] args) {
		//객체 생성
		Calculator3 myCalcu = new Calculator3();
		
		//변의 길이가 10인 정사각형 크기 구하기
		double result1=myCalcu.areaRectangle(10);
		
		//직사각형 넓이 구하기 
		double result2=myCalcu.areaRectangle(10, 20);
		
		System.out.println("정사각형 넓이="+result1);
		System.out.println("직사각형 넓이="+result2);
	}

}
