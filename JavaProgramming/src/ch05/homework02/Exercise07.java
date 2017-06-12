package ch05.homework02;

public class Exercise07 {

	public static void main(String[] args) {
		int max =0;
		int[] array={1,5,3,8,2};
		for(int arrayVal : array){
			max+=arrayVal;
		}
		
		System.out.println("max:" + max);
	}

}
