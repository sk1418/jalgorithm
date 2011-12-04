package com.kent.algorithm.demo.problem;

import java.util.Arrays;

import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.MaxSubArray;
import com.kent.util.AlgUtil;

public class MaxSubArrayDemo extends AbstractDemo {
	/** The small array. */
	private int[] smallArray;

	/** The big array. */
	private int[] bigArray;

	/** The problem. */
	private MaxSubArray problem;

	@Override
	protected void prepareDemo() {
		smallArray = AlgUtil.getRandomIntArray(SMALL_ARRAY_SIZE, 10 * SMALL_ARRAY_SIZE, true);
		bigArray = AlgUtil.getRandomIntArray(BIG_ARRAY_SIZE, 10 * BIG_ARRAY_SIZE, true);
		problem = new MaxSubArray();

	}

	@Override
	protected void specificDemo() {
		printInfo(String.format("Find max sub-array algorithm with %s complexity\n", problem.getBigO()));
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
		printInfo("array with " + a.length + " elements:");
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
		printInfo(AlgUtil.lineSeparator('=', 20));
		printInfo(stopwatch.readAsString());
		stopwatch.reset();
	}
}
