package ch15.exam06;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample1 {

	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(87);
		set.add(98);
		set.add(95);
		set.add(75);
		set.add(80);

		int min = set.first(); // 가장 작은 값
		System.out.println(min);

		int max = set.last();
		System.out.println(max);

		System.out.println("-----------------------------------------");

		Set<Integer> set2 = set.subSet(80, true, 90, false);
		for (int score : set2) {
			System.out.println(score);
		}

		System.out.println("-----------------------------------------");

		Set<Integer> set3 = set.descendingSet();
		for (int score : set3) {
			System.out.println(score);
		}

		System.out.println("-----------------------------------------");

		Set<Integer> set4 = set.descendingSet().descendingSet();
		for (int score : set4) {
			System.out.println(score);
		}
	}

}
