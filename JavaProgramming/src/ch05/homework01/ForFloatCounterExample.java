package ch05.homework01;

public class ForFloatCounterExample {

	public static void main(String[] args) {
		//0.1부터 1.0까지 0.1씩 증가 
		for(float x=0.1f; x<1.0f; x+=0.1f){
			//0.1을 float타입으로 정확히 표현 할수 없어서 약간 큰값이 더해지게 되서 오차가 발생한다.
			System.out.println(x);
		}
	}

}
