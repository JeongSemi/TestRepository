package ch05.homework01;

public class ForSumFrom1To100Example2 {

	public static void main(String[] args) {
		int sum=0;	//더한값 넣을 변수 선언
		int i=0; //카운터 변수
		//1부터 100까지 더하기
		for(i=1; i<=100; i++){
			sum+=i;
		}
		
		//더한 값 출력, 카운트된 i값 출력
		System.out.println("1~"+(i-1)+" 합: "+ sum);
	}

}
