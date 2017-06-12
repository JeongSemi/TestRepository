package ch14.exam03;

public class LambdaExpressionExample {
	public static int a = 5;

	public static void main(String[] args) {
		method1(() -> {
			a = 8;
			System.out.println(a);
		});

		int b = 5;
		method1(() -> {
			// b = 8; -> b는 로컬변수이고, 파이널 특성을 가지기 때문에 변경 불가하다.
			System.out.println(b);
		});
	}

	public static void method1(FunctionalInterface1 i) {
		i.method();
	}

}
