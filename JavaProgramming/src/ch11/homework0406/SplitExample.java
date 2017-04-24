package ch11.homework0406;

import java.util.StringTokenizer;

public class SplitExample {

	public static void main(String[] args) {
		String str = "���̵�,�̸�,�н�����";
		
		String[] str_split = str.split(",");
		for(String s : str_split)
			System.out.println(s);
		
		System.out.println();
		
		StringTokenizer stringTokenizer = new StringTokenizer(str,",");
		while(stringTokenizer.hasMoreTokens()){
			System.out.println(stringTokenizer.nextToken());
		}
		
		
	}

}
