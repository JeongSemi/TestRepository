package ch11.exam13;

import java.util.Arrays;

public class ArraysExample {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5 };
		
		System.out.println(Arrays.binarySearch(nums, 6));
		
		String[] names = {"È«±æµ¿", "±èÀÚ¹Ù", "»ç¹°ÀÎÅÍ³İ"};
		
		System.out.println(Arrays.binarySearch(names, "¿¨"));
	}

}
