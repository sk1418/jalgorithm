package com.kent.algorithm.demo.problem;

import java.util.Arrays;

import com.google.common.base.Joiner;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.FindMaxSubArray;
import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoType;
import com.kent.util.AlgUtil;

@Demo(type = DemoType.Problems, name="Find Max Sub-Array")
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
		print(AlgUtil.repeatString("=", 50));

		stopwatch.start();
		final int[] result = problem.solve(a);
		stopwatch.stop();
		print("Max Sub-Array found:");
		print("start idx:" + result[0]);
		print("end idx  :" + result[1]);
		print("Sum      :" + result[2]);
		print(AlgUtil.repeatString("=", 50));
		print(stopwatch.readAsString());
		stopwatch.reset();
	}

	@Override
	protected void printDescription() {
		//@formatter:off
		final String d =Joiner.on("\n").join(
				 "Finding Max Subarray problem:",
				 "Find the nonempty, contiguous subarray of given array, whose values have the largest sum.",
				 "",
				 "Using Divide And Conquer way to solve the problem:",
				 "",
				 "- the maxSubarray can entirely in the subarray A[low .. mid]",
				 "- entirely in the subarray A[mid+1 .. high]",
				 "- crossing the midpoint: ..i.. (maxSumLeft) ... <-mid -> .(maxSumRight)..j..."
				);
		//@formatter:on

		print(d);

	}
}
