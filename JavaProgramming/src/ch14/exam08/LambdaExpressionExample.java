package ch14.exam08;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class LambdaExpressionExample {

	private static List<Student> list = Arrays.asList(new Student("È«±æµ¿", 90, 96), new Student("±èÀÚ¹Ù", 95, 93));

	public static void main(String[] args) {
		printString((s) -> {
			return s.getName();
		});
		printInt((s) -> s.getEnglishScore());
		printInt(s -> s.getMathScore());

		double englishAvg = avg(s -> s.getEnglishScore());
		double mathAvg = avg(s -> s.getMathScore());
		System.out.println("¿µ¾î Æò±ÕÁ¡¼ö : " + englishAvg);
		System.out.println("¼öÇÐ Æò±ÕÁ¡¼ö : " + mathAvg);

	}

	public static void printString(Function<Student, String> function) {
		for (Student student : list) {
			System.out.print(function.apply(student) + " ");
		}
		System.out.println();
	}

	public static void printInt(ToIntFunction<Student> function) {
		for (Student student : list) {
			System.out.print(function.applyAsInt(student) + " ");
		}
		System.out.println();
	}

	public static double avg(ToIntFunction<Student> func) {
		int sum = 0;
		for (Student student : list) {
			sum += func.applyAsInt(student);
		}
		return (double) sum / list.size();
	}

}
