package com.kent.algorithm.problem;

import java.util.Arrays;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Test;

public class FindHeavyIntegerTest {

	private static final Logger LOG = Logger.getLogger(FindHeavyIntegerTest.class);

	@Test
	public void solutionTest() {
		final FindHeavyIntegers problem = new FindHeavyIntegers();
		final int[] input = new int[] { 1, 100 };
		final int[] result = problem.solve(input);
		final int[] expected = new int[] { 8, 9, 69, 78, 79, 87, 88, 89, 96, 97, 98, 99 };
		Assert.assertTrue("two array should equal", Arrays.equals(expected, result));
	}
}
