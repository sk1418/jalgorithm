package com.kent.algorithm.demo.problem;

import java.util.Arrays;

import com.google.common.base.Joiner;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.RemoveDupsFromSortedArray;
import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoType;
import com.kent.util.AlgUtil;

@Demo(type = DemoType.Problems, name="Remove Dups From Sorted Array")
public class RemoveDupsFromSortedArrayDemo extends AbstractDemo {

	/** The problem. */
	private RemoveDupsFromSortedArray problem;

	private final int[] input = new int[] { 1, 2, 2, 3, 3, 3, 4, 5, 5, 5 };

	@Override
	protected void prepareDemo() {

		problem = new RemoveDupsFromSortedArray();

	}

	@Override
	protected void specificDemo() {

		print("Time complexity:" + problem.getBigO());
		doJob(input);
	}

	@Override
	protected void warmingUp() {
	}

	/**
	 * Do job.
	 * 
	 * @param a
	 *            the a
	 */
	private void doJob(final int[] a) {
		print("\n\narray with " + a.length + " elements:");
		print("Array: " + Arrays.toString(a));
		print(AlgUtil.repeatString("=", 50));

		stopwatch.start();
		final int result = problem.solve(a);
		stopwatch.stop();
		print("After removing duplicates:");
		print("Array: " + Arrays.toString(a));
		print("length: " + result);
		print(stopwatch.readAsString());
		stopwatch.reset();
	}

	@Override
	protected void printDescription() {
		//@formatter:off
		final String d =Joiner.on("\n").join(
				 " Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.",
				 " ",
				 " Do not allocate extra space for another array, you must do this in place with constant memory.",
				 " ",
				 " For example,",
				 " ",
				 " ",
				 " Given input array A = [1,1,2],",
				 " ",
				 " Your function should return length = 2, and A is now [1,2].",
				 " ",
				 " ",
				 " Solution/Algorithm",
				 " ",
				 " - create two pointers (uniq and checker) to index",
				 " - compare A[checker] to A[uniq], if not equal, save checker's value to A[++uniq]; ",
				 " - checker++, check again, until the end of the array"
				);
		//@formatter:on

		print(d);

	}
}
