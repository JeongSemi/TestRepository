package ch14.exam07;

import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class SupplierExample {

	public static void main(String[] args) {
		method1(() -> {
			return "홍길동"; // arg.get()에서 홍길동을 리턴해준다.
		});
		method2(() -> 5); // arg.getAsInt()에서 5 리턴
	}

	public static void method1(Supplier<String> arg) {
		String result = arg.get();
		System.out.println(result);
	}

	public static void method2(IntSupplier arg) {
		int result = arg.getAsInt();
		System.out.println(result);
	}

}
