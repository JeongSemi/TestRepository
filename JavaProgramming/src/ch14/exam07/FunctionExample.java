package ch14.exam07;

import java.util.function.DoubleToIntFunction;
import java.util.function.Function;

public class FunctionExample {

	public static void main(String[] args) {
		method1((d) -> {
			return (int) d;
		});
		method1(d -> { // d = applyAsInt의 매개변수 -> 3.54
			return (int) Math.round(d); // applyAsInt가 return 하는 값
		});
		method2((m) -> {
			return m.getMname();
		});

	}

	public static void method1(DoubleToIntFunction arg) {
		int result = arg.applyAsInt(3.54);
		System.out.println(result);
	}

	public static void method2(Function<Member, String> arg) {
		Member member = new Member("white", "홍길동");
		String result = arg.apply(member);
		System.out.println(result);
	}

}
