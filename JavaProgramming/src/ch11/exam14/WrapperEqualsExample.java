package ch11.exam14;

public class WrapperEqualsExample {

	public static void main(String[] args) {
		Integer v1 = 10000;
		Integer v2 = 10000;
		
		System.out.println(v1 == v2);
		System.out.println(v1.intValue() == v2.intValue());
		System.out.println(v1.equals(v2));
	}

}
