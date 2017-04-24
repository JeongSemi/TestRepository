package ch15.exam08;

import java.util.TreeSet;

public class TreeSetExample1 {

	public static void main(String[] args) {
		TreeSet<Person> set = new TreeSet<Person>(new CompareByAge());

		set.add(new Person("ȫ�浿", 45));
		set.add(new Person("���ڹ�", 55));
		set.add(new Person("������", 31));

		System.out.println("-----------------------------------------");

		for (Person p : set) {
			System.out.println(p.getName() + " (" + p.getAge() + ")");
		}

	}

}
