package com.kent.algorithm.problem;

import java.util.Arrays;

import junit.framework.Assert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.Test;

/**
 * The Class FindHeavyIntegerTest.
 */
public class FindHeavyIntegerTest {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(FindHeavyIntegerTest.class);

	/**
	 * Solution test.
	 */
	@Test
	public void solutionTest() {
		final FindHeavyIntegers problem = new FindHeavyIntegers();
		final int[] input = new int[] { 1, 100 };
		final int[] result = problem.solve(input);
		final int[] expected = new int[] { 8, 9, 69, 78, 79, 87, 88, 89, 96, 97, 98, 99 };
		Assert.assertTrue("two array should equal", Arrays.equals(expected, result));
	}
}
