package ch05.homework01;

public class ForSumFrom1To100Example {

	public static void main(String[] args) {
		int sum=0;	//더한값 넣을 변수 선언
		
		//1부터 100까지 더하기
		for(int i=1; i<=100; i++){
			sum+=i;
		}
		
		//더한 값 출력
		System.out.println("1~100 합 :"+ sum);
	}

}
