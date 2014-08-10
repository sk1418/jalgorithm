package com.kent.algorithm.demo.problem;

import java.util.Arrays;

import com.kent.algorithm.Problem;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.PlusOne;
import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoType;
import com.kent.util.AlgUtil;

@Demo(type = DemoType.Problems, name="Plus One")
public class PlusOneDemo extends AbstractDemo {

	/** The problem. */
	private Problem<int[], int[]> problem;
	private int[] input1;
	private int[] input2;

	@Override
	protected void prepareDemo() {
		input1 = new int[] { 2, 3, 4, 5, 9 };
		input2 = new int[] { 9, 9, 9, 9, 9 };
		problem = new PlusOne();
		problem.setPrintSteps(true);
	}

	@Override
	protected void specificDemo() {

		print("Time complexity:" + problem.getBigO());
		doJob(input1);
		doJob(input2);
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
	private void doJob(final int[] a) {

		print("\n\narray with " + a.length + " elements:");
		print("Array : " + Arrays.toString(a));
		print(AlgUtil.repeatString("=", 50));

		stopwatch.start();
		final int[] result = problem.solve(a);
		stopwatch.stop();
		print("Result: " + Arrays.toString(result));
		print(AlgUtil.repeatString("=", 50));
		print(stopwatch.readAsString());
		stopwatch.reset();
	}

	@Override
	protected void printDescription() {

		print(" Given a number represented as an array of digits, plus one to the number. ");

	}
}
