package ch11.exam15;

import java.util.Random;

public class RandomExample {

	public static void main(String[] args) {
		double random = Math.random();
		int num = (int)(random*10)%6+1;
		
		/*
		 int maxNum = 6;
		 int num = (int)(random*maxNum) + 1;
		 */
		
		System.out.println(num);
		
		//또다른방법
		 Random obj = new Random();
		 int num2 = obj.nextInt(6)+1;
		 System.out.println(num2);
		
		

	}

}
