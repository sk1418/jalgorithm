/*
 * 
 */
package com.kent.algorithm;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.kent.algorithm.misc.CountInversionPairs;
import com.kent.algorithm.misc.MaxSubArray;
import com.kent.algorithm.misc.MiscAlgorithm;
import com.kent.test.BaseTest;

/**
 * The Class MiscTest.
 */
public class MiscTest extends BaseTest {

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(MiscTest.class);

	/**
	 * Count inversions test.
	 */
	@Test
	public void countInversionsTest() {
		testInfo("countInversions");
		final int[] testArray = new int[] { 5, 4, 3, 2, 1 };
		final int[] testArray2 = new int[] { 1, 2, 3, 4, 5 };
		final int[] testArray3 = new int[] { 2, 3, 8, 5, 1 };
		final MiscAlgorithm<int[], Long> misc = new CountInversionPairs();
		final long c = misc.execute(testArray);
		final long c2 = misc.execute(testArray2);
		final long c3 = misc.execute(testArray3);

		Assert.assertEquals(10L, c);
		Assert.assertEquals(0L, c2);
		Assert.assertEquals(5L, c3);
	}

	@Test
	public void findMaxSubArrayTest() {
		testInfo("findMaxSubArray");
		final int[] testArray = new int[] { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
		final MiscAlgorithm<int[], int[]> maxSubTest = new MaxSubArray();
		final int[] result = maxSubTest.execute(testArray);

		Assert.assertEquals(7, result[0]);
		Assert.assertEquals(10, result[1]);
	}

}
