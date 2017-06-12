package ch11.exam03;

public class MemberExample {

	public static void main(String[] args) {
		Member m1 = new Member("blue");
		System.out.println(m1.toString());
		System.out.println(m1);
		
		String result = m1 + " good!"; //m1의 대표문자열을 얻어서 + 연산 수행 -> toString()을 통해 얻은 대표문자열
	}

}
