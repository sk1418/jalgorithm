package com.kent.algorithm;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.kent.algorithm.misc.CountInversionPairs;
import com.kent.algorithm.misc.MiscAlgorithm;
import com.kent.test.BaseTest;

public class MiscTest extends BaseTest {
	private static final Logger LOG = Logger.getLogger(MiscTest.class);

	@Test
	public void countInversionsTest() {
		final int[] testArray = new int[] { 5, 4, 3, 2, 1 };
		final int[] testArray2 = new int[] { 1, 2, 3, 4, 5 };
		final int[] testArray3 = new int[] { 2, 3, 8, 5, 1 };
		final MiscAlgorithm<int[], Long> misc = new CountInversionPairs();
		final long c = misc.execute(testArray);
		final long c2 = misc.execute(testArray2);
		final long c3 = misc.execute(testArray3);

		Assert.assertEquals(10l, c);
		Assert.assertEquals(0l, c2);
		Assert.assertEquals(5l, c3);
	}

}
