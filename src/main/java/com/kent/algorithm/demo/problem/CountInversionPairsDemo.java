package com.kent.algorithm.demo.problem;

import java.util.Arrays;

import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.CountInversionPairs;
import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoType;
import com.kent.util.AlgUtil;

/**
 * The Class CountInversionPairsDemo.
 */
@Demo(type = DemoType.Problems, name="Count Inversion Pairs in Array")
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
		print(String.format("Counting inversion pairs algorithm with %s complexity\n", problem.getBigO()));
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
		print("array with " + a.length + " elements:");
		if (a.length == SMALL_ARRAY_SIZE) {
			print("Array: " + Arrays.toString(a));
		}
		print(AlgUtil.repeatString("=", 50));
		long c = 0;
		stopwatch.start();
		c = problem.solve(a);
		stopwatch.stop();
		print(String.format("Count of inversion pairs: %s (%s ms)\n", c, stopwatch.read()));
		stopwatch.reset();
	}

	@Override
	protected String demoDescription() {
		//@formatter:off
		return"find out counts of inversion pairs in an array using (n log n) algorithm, e.g. MergeSort";
		//@formatter:on

	}
}
