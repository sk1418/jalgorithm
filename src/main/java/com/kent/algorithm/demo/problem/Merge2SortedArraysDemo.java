package com.kent.algorithm.demo.problem;

import java.util.Arrays;
import java.util.Map;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import com.kent.algorithm.Problem;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.Merge2SortedArrays;
import com.kent.algorithm.problem.PlusOne;
import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoType;
import com.kent.util.AlgUtil;

@Demo(type = DemoType.Problems, name="Merge 2 Sorted Arrays")
public class Merge2SortedArraysDemo extends AbstractDemo {

	/** The problem. */
	private Problem<Map<String, Object>, int[]> problem = new Merge2SortedArrays();
	private Map<String, Object> input = Maps.newHashMap();

	final int[] A = new int[] {1,3,5,7,9,0,0,0,0,0,0,0,0};
	final int[] B = new int[] {2,4,6,8,10};
	Integer m = 5, n=5;

	@Override
	protected void prepareDemo() {
		problem.setPrintSteps(true);
		input.put("A", A);
		input.put("B", B);
		input.put("m", m);
		input.put("n", n);

	}

	@Override
	protected void specificDemo() {

		print("Time complexity:" + problem.getBigO());
		doJob();
	}

	@Override
	protected void warmingUp() {
		// warmingUp is not required
	}

	/**
	 * Do job.
	 * 
	 */
	private void doJob() {

		print("Array A[]: " + Arrays.toString(A));
		print("Array B[]: " + Arrays.toString(B));
		print("    m    : " + m);
		print("    n    : " + n);
		print(AlgUtil.repeatString("=", 50));

		stopwatch.start();
		final int[] result = problem.solve(input);
		stopwatch.stop();
		print("Result: " + Arrays.toString(result));
		print(AlgUtil.repeatString("=", 50));
		print(stopwatch.readAsString());
		stopwatch.reset();
	}

	@Override
	protected String demoDescription() {

		//@formatter:off
		return Joiner.on("\n").join(
				"",
				"Given two sorted integer arrays A and B, merge B into A as one sorted array.",
				"",
				"You may assume that A has enough space (size that is greater or equal to m + n)",
				"to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.",
				"",
				"Inputs:",
				"A[]  - the array A",
				"m    - the size of sorted elements in A",
				"B[]  - the array B",
				"n    - the size of B",
				"",
				">Solution<",
				"- merge from the rear of both arrays"

				);
		//@formatter:on


	}
}
