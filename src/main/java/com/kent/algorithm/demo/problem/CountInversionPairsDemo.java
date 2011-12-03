package com.kent.algorithm.demo.problem;

import java.util.Arrays;

import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.CountInversionPairs;
import com.kent.util.AlgUtil;

/**
 * The Class CountInversionPairsDemo.
 */
public class CountInversionPairsDemo extends AbstractDemo {

	/** The small array. */
	private int[] smallArray;

	/** The big array. */
	private int[] bigArray;

	/** The problem. */
	private CountInversionPairs problem;

	/** {@inheritDoc} */
	@Override
	protected void prepareDemo() {
		smallArray = AlgUtil.getRandomIntArray(SMALL_ARRAY_SIZE, 5 * SMALL_ARRAY_SIZE, false);
		bigArray = AlgUtil.getRandomIntArray(BIG_ARRAY_SIZE, 5 * BIG_ARRAY_SIZE, false);
		problem = new CountInversionPairs();
	}

	/** {@inheritDoc} */
	@Override
	protected void specificDemo() {
		printInfo(String.format("Counting inversion pairs algorithm with %s complexity\n", problem.getBigO()));
		doJob(bigArray);
		doJob(smallArray);

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
		long c = 0;
		stopwatch.start();
		c = problem.solve(a);
		stopwatch.stop();
		printInfo(String.format("Count of inversion pairs: %s (%s ms)\n", c, stopwatch.read()));
		stopwatch.reset();
	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(final String[] args) {
		final AbstractDemo demo = new CountInversionPairsDemo();
		demo.doDemo();
	}
}
