package com.kent.algorithm.demo.problem;

import static com.kent.util.AlgUtil.*;

import com.google.common.base.Joiner;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.FindHeavyIntegers;

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

		print(repeatString("=", 50));

		stopwatch.start();
		final int[] result = problem.solve(a);
		stopwatch.stop();
		print("Found Heavy Integers :" + result.length);
		if (result.length < 20) {
			printIntArray(result);
		} else {
			print("first  :" + result[0]);
			print("last   :" + result[result.length - 1]);
		}
		print(stopwatch.readAsString());
		print(repeatString("=", 50));
		stopwatch.reset();
	}

	@Override
	protected void printDescription() {

		//@formatter:off
		final String d =Joiner.on("\n").join(
				"Finding Heavy integers:",
				"A non-negative integer is called heavy if the average value of its digits in decimal representation",
				"exceeds 7. For example the number 8698 is heavy, because the average value of its digits equal to",
				"(8+6+9+8)/4 = 7.75",
				"",
				"Given two non-negative integers A and B find the number of heavy integers ",
				"in the interval [A..B] (A and B included),A and B are integers within the range [0..200,000,000].",
				"",
				"The algorithm is to skip the numbers which are guaranteed to give a sub-average value. ",
				"If sumDigits is the sum of the digits and numDigits is the number of digits, then ",
				"if sumDigits <= 7 * numDigits, we skip it and we need at least ",
				"(7 * numDigits)-sumDigits+1 to bring the digits avg above 7.0. The trick is to ",
				"increment the number (starting from the units place) so that the total average goes ",
				"above 7.0; To take an example, if the number is 10000, sumDigits = 1 and avg of ",
				"digits = 0.2. The deficit in sum is 7*5-1 +1= 35, so we can increment 10000 by 8999 ",
				"i.e we increase the sum by 8+9+9+9 = 35 and new number = 18999 has sumDigits =36 ",
				"and average of digits becomes greater than 7.0"		
		);
		//@formatter:on

		print(d);

	}
}
