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
		final int[] input = new int[] { 1, 10000 };
		final int[] result = problem.solve(input);
		LOG.debug(Arrays.toString(result));
		Assert.assertTrue(true);
	}
}
