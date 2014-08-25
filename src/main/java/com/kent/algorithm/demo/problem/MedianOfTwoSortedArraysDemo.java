package com.kent.algorithm.demo.problem;

import java.util.Arrays;
import java.util.List;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.MedianOfTwoSortedArrays;
import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoType;
import com.kent.util.AlgUtil;

@Demo(type = DemoType.Problems, name="Median Of Two Sorted Arrays")
public class MedianOfTwoSortedArraysDemo extends AbstractDemo {
	private List<int[]> input1;
	private List<int[]> input2;
	private List<int[]> input3;

	/** The problem. */
	private MedianOfTwoSortedArrays problem;

	@Override
	protected void prepareDemo() {
		input1 = ImmutableList.of(new int[] { 1, 3, 5, 7, 9 }, new int[] { 2, 4, 6, 8, 10 });
		input2 = ImmutableList.of(new int[] {}, new int[] { 1, 2, 3, 4, 5 });
		input3 = ImmutableList.of(new int[] { 4 }, new int[] { 1, 2, 3, 5 });

		problem = new MedianOfTwoSortedArrays();
	}

	@Override
	protected void specificDemo() {

		print("Time complexity:" + problem.getBigO());
		doJob(input1);
		doJob(input2);
		doJob(input3);
	}

	@Override
	protected void warmingUp() {
		// warmingUp is not required
	}

	/**
	 * Do job.
	 * 
	 * @param a
	 *            the a
	 */
	private void doJob(final List<int[]> input) {

		print("Array A: " + Arrays.toString(input.get(0)));
		print("Array B: " + Arrays.toString(input.get(1)));
		print(AlgUtil.repeatString("=", 50));

		stopwatch.start();
		final double result = problem.solve(input);
		stopwatch.stop();
		print("Median : " + result);
		print(AlgUtil.repeatString("=", 50));
		print(stopwatch.readAsString());
		stopwatch.reset();
	}

	@Override
	protected String demoDescription() {
		//@formatter:off
		return Joiner.on("\n").join(
				 " There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.",
				 " ",
				 " The overall run time complexity should be O(log (m+n)).",
				 " ",
				 " Solution: The basic idea is that if you are given two arrays A and B and know the length of each, you can check whether an element A[i] is the",
				 " median in constant time. Suppose that the median is A[i]. Since the array is sorted, it is greater than exactly i − 1 values in array A. Then if it",
				 " is the median, it is also greater than exactly",
				 " ",
				 " j = n / 2 - (i - 1)",
				 " ",
				 " elements in B. It requires constant time to check if",
				 " ",
				 " B[j]<= A[i] <= B[j + 1].",
				 " ",
				 " If A[i] is not the median, then depending on whether A[i] is greater or less than B[j] and B[j + 1], you know that A[i] is either greater than or",
				 " less than the median. Thus you can binary search for A[i] in O(lg n) worst-case time.",
				 " ",
				 " the above solution works when the total number of elements is odd. if n is even. The found median is the larger element, need to find out the",
				 " smaller element and do a average."

				);
		//@formatter:on


	}
}
