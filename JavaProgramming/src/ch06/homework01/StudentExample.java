package ch06.homework01;

public class StudentExample {

	public static void main(String[] args) {
		//Student 객체 생성, 컴파일러가 생성자 자동 생성
		Student s1=new Student();
		System.out.println("s1변수가 Student객체를 참조합니다. ");
		
		//이정과 다른 Student 객체 생성, 컴파일러가 생성자 자동생성
		Student s2=new Student();
		System.out.println("s2변수가 또다른 Student객체를 참조합니다. ");
	}

}
