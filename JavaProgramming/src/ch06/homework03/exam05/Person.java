package ch06.homework03.exam05;

public class Person {
	//nation final 선언 및 초기화, 바꿀수 없음 
	final String nation ="Korea";
	
	//ssn final 선언 , 초기화는 생성때 
	final String ssn;
	String name;
	//생성자 호출시 ssn초기화 
	public Person(String ssn, String name){
		this.ssn=ssn;
		this.name=name;
	}
}
