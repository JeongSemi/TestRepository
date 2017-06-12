package ch14.exam09;

import java.util.function.IntBinaryOperator;

public class LambdaExpressionExample {
	private static int[] scores = { 92, 95, 87 };

	public static void main(String[] args) {

		int max = maxOrMin(Math::max);
		// max = ((a,b)->{return Math.max(a,b);});
		int min = maxOrMin(Math::min);
		// min = ((a,b)->{return MAth.min(a,b);});

		System.out.println("Max : " + max);
		System.out.println("Min : " + min);
	}

	public static int maxOrMin(IntBinaryOperator operator) {
		int result = scores[0];
		for (int score : scores) {
			result = operator.applyAsInt(result, score);
		}
		return result;
	}

}
