package com.kent.algorithm.demo.problem;

import java.util.Arrays;

import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.FindHeavyIntegers;
import com.kent.util.AlgUtil;

public class FindHeavyIntegerDemo extends AbstractDemo {
	private int[] firstRun, secondRun;

	private FindHeavyIntegers problem;

	@Override
	protected void warmingUp() {
		// problem.solve(firstRun);
		// problem.solve(secondRun);
	}

	@Override
	protected void prepareDemo() {
		firstRun = new int[] { 1, 100 };
		secondRun = new int[] { 1000, 100000 };
		problem = new FindHeavyIntegers();

	}

	@Override
	protected void specificDemo() {
		print("Time complexity:" + problem.getBigO());
		doJob(firstRun);
		doJob(secondRun);
	}

	@Override
	protected void printDescription() {
		print(problem.getDescription().toString());

	}

	private void doJob(final int[] a) {
		print("\nHeavy Integers between " + a[0] + " and " + a[1] + ":");

		print(AlgUtil.lineSeparator('=', 50));

		stopwatch.start();
		final int[] result = problem.solve(a);
		stopwatch.stop();
		print("Found Heavy Integers :" + result.length);
		if (result.length < 20) {
			print(Arrays.toString(result));
		} else {
			print("first  :" + result[0]);
			print("last   :" + result[result.length - 1]);
		}
		print(stopwatch.readAsString());
		print(AlgUtil.lineSeparator('=', 50));
		stopwatch.reset();
	}

}
