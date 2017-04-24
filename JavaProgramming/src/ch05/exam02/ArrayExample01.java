package ch05.exam02;

public class ArrayExample01 {

	public static void main(String[] args) {
		int[] v1 = { 80, 90, 87 };
		int[] v2 = { 80, 90, 87, 70 };
		String[] v3 = { "java", "Progrman" };

		System.out.println(v1 == v2); // false
		System.out.println(v1[0] == v2[0]); // true
		System.out.println(v1.length); // 3
		System.out.println(v2.length); // 4
		System.out.println(v3.length); // 2
		System.out.println(args.length); // 0, 비어있는 객체가 들어온다.

		int v4 = 0;
		for (int i = 0; i < v1.length; i++) {
			v4 += v1[i];
		}

		System.out.println(v4);
	}

}
