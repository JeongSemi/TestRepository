package ch05.exam01;

public class CompareValueExample {

	public static void main(String[] args) {
		int v1=10;
		int v2=10;
		System.out.println(v1==v2);
		
		int[] v3={10};
		int[] v4=v3;
		System.out.println(v3==v4);
	
		String v5 ="java";
		String v6 =new String("java");	//같은 객체에 있는 "java"를 가르키는 것이다. 
		System.out.println(v5==v6);

		//객체비교가 아닌 문자열 비교하고 싶을때 
		System.out.println(v5.equals(v6));
	}

}
