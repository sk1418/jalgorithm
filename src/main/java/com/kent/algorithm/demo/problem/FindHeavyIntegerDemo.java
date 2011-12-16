package com.kent.algorithm.demo.problem;

import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.FindHeavyIntegers;
import com.kent.util.AlgUtil;

public class FindHeavyIntegerDemo extends AbstractDemo {
	private int[] firstRun, secondRun;

	private FindHeavyIntegers problem;

	@Override
	protected void warmingUp() {
		problem.solve(firstRun);
		problem.solve(secondRun);
	}

	@Override
	protected void prepareDemo() {
		firstRun = new int[] { 1, 100 };
		secondRun = new int[] { 1, 1000000 };
		problem = new FindHeavyIntegers();

	}

	@Override
	protected void specificDemo() {
		print("Time complexity:" + problem.getBigO());
		doJob(firstRun);
		doJob(secondRun);
	}

	private void doJob(final int[] a) {
		print("\nHeavy Integers between " + a[0] + " and " + a[1] + ":");

		print(AlgUtil.repeatString("=", 50));

		stopwatch.start();
		final int[] result = problem.solve(a);
		stopwatch.stop();
		print("Found Heavy Integers :" + result.length);
		if (result.length < 20) {
			AlgUtil.printIntArray(result);
		} else {
			print("first  :" + result[0]);
			print("last   :" + result[result.length - 1]);
		}
		print(stopwatch.readAsString());
		print(AlgUtil.repeatString("=", 50));
		stopwatch.reset();
	}

	@Override
	protected void printDescription() {
		final StringBuffer sb = new StringBuffer();
		AlgUtil.appendNewline(sb, "Finding Heavy integers:");
		AlgUtil.appendNewline(sb, "A non-negative integer is called heavy if the average value of its digits in decimal representation");
		AlgUtil.appendNewline(sb, "exceeds 7. For example the number 8698 is heavy, because the average value of its digits equal to");
		AlgUtil.appendNewline(sb, "(8+6+9+8)/4 = 7.75");
		AlgUtil.appendNewline(sb, "");
		AlgUtil.appendNewline(sb, "Given two non-negative integers A and B find the number of heavy integers ");
		AlgUtil.appendNewline(sb, "in the interval [A..B] (A and B included),A and B are integers within the range [0..200,000,000].");
		AlgUtil.appendNewline(sb, "");
		AlgUtil.appendNewline(sb, "The algorithm is to skip the numbers which are guaranteed to give a sub-average value. ");
		AlgUtil.appendNewline(sb, "If sumDigits is the sum of the digits and numDigits is the number of digits, then ");
		AlgUtil.appendNewline(sb, "if sumDigits <= 7 * numDigits, we skip it and we need at least ");
		AlgUtil.appendNewline(sb, "(7 * numDigits)-sumDigits+1 to bring the digits avg above 7.0. The trick is to ");
		AlgUtil.appendNewline(sb, "increment the number (starting from the units place) so that the total average goes ");
		AlgUtil.appendNewline(sb, "above 7.0; To take an example, if the number is 10000, sumDigits = 1 and avg of ");
		AlgUtil.appendNewline(sb, "digits = 0.2. The deficit in sum is 7*5-1 +1= 35, so we can increment 10000 by 8999 ");
		AlgUtil.appendNewline(sb, "i.e we increase the sum by 8+9+9+9 = 35 and new number = 18999 has sumDigits =36 ");
		AlgUtil.appendNewline(sb, "and average of digits becomes greater than 7.0");

		print(sb.toString());

	}
}
