package com.kent.algorithm.problem;

import junit.framework.Assert;

import org.junit.Test;

public class BinarySearchProblemTest {

	@Test
	public void binarySearchTest() {

		final int[] testArray = new int[] { 0, 2, 16, 17, 23, 23, 28, 32, 34, 39, 56, 82, 90, 106, 768 };
		final int target = 0;

		int[][] input = { testArray, { 28 } };

		final BinarySearchProblem problem = new BinarySearchProblem();
		int result = problem.solve(input);
		Assert.assertEquals(6, result);
		// doesn't exist
		input = new int[][] { testArray, { 88 } };
		result = problem.solve(input);
		Assert.assertEquals(-1, result);

	}
}
