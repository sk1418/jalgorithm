package com.kent.algorithm.problem;

import junit.framework.Assert;

import org.junit.Test;

import com.kent.algorithm.problem.MaxSubArray;
import com.kent.algorithm.problem.Problem;
import com.kent.test.BaseTest;

public class FindMaxSubArrayTest extends BaseTest{
	@Test
	public void findMaxSubArrayTest() {
		testInfo("findMaxSubArray");
		final int[] testArray = new int[] { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
		final Problem<int[], int[]> maxSubTest = new MaxSubArray();
		final int[] result = maxSubTest.solve(testArray);

		Assert.assertEquals(7, result[0]);
		Assert.assertEquals(10, result[1]);
	}
}
