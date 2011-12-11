package com.kent.algorithm.demo.problem;

import java.util.Arrays;

import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.FindMaxSubArray;
import com.kent.util.AlgUtil;

public class MaxSubArrayDemo extends AbstractDemo {
	/** The small array. */
	private int[] smallArray;

	/** The big array. */
	private int[] bigArray;

	/** The problem. */
	private FindMaxSubArray problem;

	@Override
	protected void prepareDemo() {
		smallArray = AlgUtil.getRandomIntArray(SMALL_ARRAY_SIZE, 10 * SMALL_ARRAY_SIZE, true);
		bigArray = AlgUtil.getRandomIntArray(BIG_ARRAY_SIZE, 10 * BIG_ARRAY_SIZE, true);
		problem = new FindMaxSubArray();

	}

	@Override
	protected void specificDemo() {
		printInfo(AlgUtil.lineSeparator('#', 70));
		problem.printDesc();
		printInfo(AlgUtil.lineSeparator('#', 70));
		printInfo("");
		printInfo("");
		printInfo("Time complexity:" + problem.getBigO());
		doJob(bigArray);
		doJob(smallArray);
	}

	@Override
	protected void warmingUp() {

		problem.solve(smallArray);
		problem.solve(bigArray);
	}

	/**
	 * Do job.
	 * 
	 * @param a
	 *            the a
	 */
	private void doJob(final int[] a) {
		printInfo("\n\narray with " + a.length + " elements:");
		if (a.length == SMALL_ARRAY_SIZE) {
			printInfo("Array: " + Arrays.toString(a));
		}
		printInfo(AlgUtil.lineSeparator('=', 50));

		stopwatch.start();
		final int[] result = problem.solve(a);
		stopwatch.stop();
		printInfo("Max Sub-Array found:");
		printInfo("start idx:" + result[0]);
		printInfo("end idx  :" + result[1]);
		printInfo("Sum      :" + result[2]);
		printInfo(AlgUtil.lineSeparator('=', 50));
		printInfo(stopwatch.readAsString());
		stopwatch.reset();
	}
}
