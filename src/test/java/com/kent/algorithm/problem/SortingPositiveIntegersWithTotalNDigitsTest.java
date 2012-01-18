package com.kent.algorithm.problem;

import org.junit.Assert;
import org.junit.Test;

import com.kent.test.BaseTest;

public class SortingPositiveIntegersWithTotalNDigitsTest extends BaseTest {

	@Test
	public void testSolve() {
		final SortingPositiveIntegersWithTotalNDigits target = new SortingPositiveIntegersWithTotalNDigits();

		final int[] testArray = new int[] { 5, 233, 4270, 39, 10, 477, 5075, 59902000, 24902000, 23450 };
		final int[] sortedArray = new int[] { 5, 10, 39, 233, 477, 4270, 5075, 23450, 24902000, 59902000 };

		final int[] result = target.solve(testArray);

		Assert.assertArrayEquals(sortedArray, result);

	}
}
