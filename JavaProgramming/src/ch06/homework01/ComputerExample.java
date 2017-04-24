package ch06.homework01;

public class ComputerExample {

	public static void main(String[] args) {
		//객체 생성
		Computer myCom =new Computer();
		
		//배열선언
		int[] values1={1,2,3};
		
		//sum1메소드 실행 (매개변수로 배열 전달)
		int result1=myCom.sum1(values1);
		System.out.println("result1:"+result1);
		
		//배열 객체를 새로 생성하여 sum1메소드 실행(매개변수로 배열 전달)
		int result2=myCom.sum1(new int[]{1,2,3,4,5});
		System.out.println("result2:"+result2);
		
		//new int[] {1,2,3} 
		int result3=myCom.sum2(1,2,3);
		System.out.println("result2:"+result3);
		
		//new int[] {1,2,3,4,5}
		int result4=myCom.sum2(1,2,3,4,5);
		System.out.println("result2:"+result4);
	}

}
