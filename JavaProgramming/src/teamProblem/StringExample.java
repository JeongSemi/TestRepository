package teamProblem;

import java.util.StringTokenizer;

public class StringExample {

	public static void main(String[] args) {
		String str1 = "Team Problem";
		String str2 = "Team Problem";
		
		
		if(str1.equals(str2))
		{
			String str3 = str2.replace("Team", "Semi");
			System.out.println(str2 + " -> " + str3);
		}
		else
			System.out.println(str1);
		
		if(str2.charAt(4)=='m')
		{
			System.out.println(str2.substring(0,4));
		}
		else
		{
			StringTokenizer st = new StringTokenizer(str2, " ");
			System.out.println(st.nextToken());
		}
		
		if(str1.indexOf("m") == 11)
		{
			System.out.println(str1.toLowerCase());
		}
		else
		{
			System.out.println(str2.toUpperCase());
		}
	}
}
