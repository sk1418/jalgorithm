/*
 * 
 */
package com.kent.algorithm.problem;

import junit.framework.Assert;

import com.kent.algorithm.Problem;
import com.kent.test.BaseTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.Test;

/**
 * The Class MiscTest.
 */
public class TwoSumInArrayTest extends BaseTest {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(TwoSumInArrayTest.class);

	/**
	 * Count inversions test.
	 */
	@Test
	public void countInversionsTest() {
		testInfo("two sum in Array");
		// the first element (index 0) is the sum target
		final int[] testArray = new int[] { 9, 10, 2, 11, 1, 7, 15 };
		final Problem<int[], int[]> problem = new TwoSumInArray();
		final int[] result = problem.solve(testArray);
		Assert.assertEquals(2, result[0]);
		Assert.assertEquals(5, result[1]);
	}

}
