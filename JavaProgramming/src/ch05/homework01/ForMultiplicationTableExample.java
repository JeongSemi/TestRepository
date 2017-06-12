package ch05.homework01;

public class ForMultiplicationTableExample {

	public static void main(String[] args) {
		//2단부터 9단까지 출력, 2중 for문
		for(int m=2; m<=9; m++){
			System.out.println("*** " + m + "단 ***");
			//1부터 9까지 곱
			for(int n=1; n<=9; n++){
				System.out.println(m + "X"+n+" = "+(m*n));
			}
		}
	}

}
