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
public class CountInversionPairsTest extends BaseTest {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(CountInversionPairsTest.class);

	/**
	 * Count inversions test.
	 */
	@Test
	public void countInversionsTest() {
		testInfo("countInversions");
		final int[] testArray = new int[] { 5, 4, 3, 2, 1 };
		final int[] testArray2 = new int[] { 1, 2, 3, 4, 5 };
		final int[] testArray3 = new int[] { 2, 3, 8, 5, 1 };
		final Problem<int[], Long> misc = new CountInversionPairs();
		final long c = misc.solve(testArray);
		final long c2 = misc.solve(testArray2);
		final long c3 = misc.solve(testArray3);

		Assert.assertEquals(10L, c);
		Assert.assertEquals(0L, c2);
		Assert.assertEquals(5L, c3);
	}

}
