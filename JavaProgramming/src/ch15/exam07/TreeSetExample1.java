package ch15.exam07;

import java.util.Collections;
import java.util.TreeSet;

public class TreeSetExample1 {

	public static void main(String[] args) {
		TreeSet<Person> set = new TreeSet<Person>();
		
		set.add(new Person("홍길동", 45));
		set.add(new Person("감자바", 25));
		set.add(new Person("박지원", 31));

		System.out.println("-----------------------------------------");

		for (Person p : set) {
			System.out.println(p.getName() + " (" + p.getAge() + ")");
		}

	}

}
