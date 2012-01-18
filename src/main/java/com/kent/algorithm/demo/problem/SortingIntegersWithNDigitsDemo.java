package com.kent.algorithm.demo.problem;

import java.util.Arrays;

import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.SortingPositiveIntegersWithTotalNDigits;
import com.kent.util.AlgUtil;

public class SortingIntegersWithNDigitsDemo extends AbstractDemo {
	/** The small array. */
	private int[] smallArray;

	/** The big array. */
	private int[] bigArray;

	/** The problem. */
	private SortingPositiveIntegersWithTotalNDigits problem;

	@Override
	protected void prepareDemo() {
		smallArray = new int[] { 5, 233, 4270, 39, 10, 477, 5075, 59902000, 24902000, 23450, 24848, 20399989, 8829, 224, 3, 88933, 773345, 23455,
				1002, 50030 };
		problem = new SortingPositiveIntegersWithTotalNDigits();
		problem.setPrintSteps(true);

	}

	@Override
	protected void specificDemo() {

		print("Time complexity:" + problem.getBigO());
		doJob(smallArray);
	}

	@Override
	protected void warmingUp() {
		// do not need warmingUp

	}

	/**
	 * Do job.
	 * 
	 * @param a
	 *            the a
	 */
	private void doJob(final int[] a) {
		print("Array: " + Arrays.toString(a));
		print(AlgUtil.repeatString("=", 50));

		stopwatch.start();
		final int[] result = problem.solve(a);
		stopwatch.stop();
		print(AlgUtil.repeatString("=", 50));
		print(stopwatch.readAsString());
		stopwatch.reset();
	}

	@Override
	protected void printDescription() {
		final StringBuffer sb = new StringBuffer();
		AlgUtil.appendNewline(sb, "You are given an array of integers, where different integers may have");
		AlgUtil.appendNewline(sb, "different numbers of digits, but the total number of digits over all the");
		AlgUtil.appendNewline(sb, "integers in the array is n. Show how to sort the array in O(n) time.");
		AlgUtil.appendNewline(sb, "  ");
		AlgUtil.appendNewline(sb, "Let us assume that all the integers are positive and have no leading");
		AlgUtil.appendNewline(sb, "zeros. Under this assumption, we can observe that integers with more");
		AlgUtil.appendNewline(sb, "digits are always greater than integers with fewer digits. Thus, we can");
		AlgUtil.appendNewline(sb, "first sort the integers by number of digits (using counting sort), and");
		AlgUtil.appendNewline(sb, "then use radix sort to sort each group of integers with the same length.");

		print(sb.toString());

	}
}
