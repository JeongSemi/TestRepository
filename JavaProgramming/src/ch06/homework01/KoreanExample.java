package ch06.homework01;

public class KoreanExample {

	public static void main(String[] args) {
		//객체 생성, 매개변수 필요함
		Korean k1=new Korean("박자바", "011225-1234567");
		System.out.println("k1.name:"+k1.name);
		System.out.println("k1.ssn:"+k1.ssn);
		
		//또다른 객체 생성(2개 생성), 매개변수 필요함
		Korean k2=new Korean("김자바", "930525-0654321");
		System.out.println("k2.name:"+k2.name);
		System.out.println("k2.ssn:"+k2.ssn);
	}

}
