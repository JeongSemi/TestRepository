package ch06.homework03.exam05;

public class PersonExample {

	public static void main(String[] args) {
		Person p1=new Person("123456-1234567", "계백");
		
		System.out.println(p1.nation);
		System.out.println(p1.ssn);
		System.out.println(p1.name);
		
		//p1.nation ="usa"; 변경이 불가능
		//p1.ssn ="654321-7654321"; 변경이 불가능
		p1.name="을지문덕"; 	//final이 이나기 때문에 변경이 가능하다. 
	}

}
