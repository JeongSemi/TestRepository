package ch05.homework01;

public class ContinueExample {

	public static void main(String[] args) {
		for(int i=1; i<=10; i++){
			//2의 배수가 아니면 출력 하지 않음
			if(i%2 != 0){
				continue;
			}
			System.out.println(i);	//2의 배수만 출력됨
		}
	}

}
