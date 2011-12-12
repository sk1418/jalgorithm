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

		print("Time complexity:" + problem.getBigO());
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
		print("\n\narray with " + a.length + " elements:");
		if (a.length == SMALL_ARRAY_SIZE) {
			print("Array: " + Arrays.toString(a));
		}
		print(AlgUtil.lineSeparator('=', 50));

		stopwatch.start();
		final int[] result = problem.solve(a);
		stopwatch.stop();
		print("Max Sub-Array found:");
		print("start idx:" + result[0]);
		print("end idx  :" + result[1]);
		print("Sum      :" + result[2]);
		print(AlgUtil.lineSeparator('=', 50));
		print(stopwatch.readAsString());
		stopwatch.reset();
	}

	@Override
	protected void printDescription() {
		final StringBuffer sb = new StringBuffer();
		AlgUtil.appendNewline(sb, "Finding Max Subarray problem:");
		AlgUtil.appendNewline(sb, "Find the nonempty, contiguous subarray of given array, whose values have the largest sum.");
		AlgUtil.appendNewline(sb, "");
		AlgUtil.appendNewline(sb, "Using Divide And Conquer way to solve the problem:");
		AlgUtil.appendNewline(sb, "");
		AlgUtil.appendNewline(sb, "- the maxSubarray can entirely in the subarray A[low .. mid]");
		AlgUtil.appendNewline(sb, "- entirely in the subarray A[mid+1 .. high]");
		AlgUtil.appendNewline(sb, "- crossing the midpoint: ..i.. (maxSumLeft) ... <-mid -> .(maxSumRight)..j...");

		print(sb.toString());

	}
}
