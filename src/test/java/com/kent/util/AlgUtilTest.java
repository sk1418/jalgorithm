package com.kent.util;

import junit.framework.Assert;

import org.junit.Test;

/**
 * The Class AlgUtilTest.
 */
public class AlgUtilTest {

	/**
	 * Gets the random int array test.
	 * 
	 * 
	 */
	@Test
	public void getRandomIntArrayTest() {
		final int[] a = AlgUtil.getRandomIntArray(100, 10000, false);
		final int[] b = AlgUtil.getRandomIntArray(100, 20, true);

		for (int i = 0; i < a.length; i++) {
			Assert.assertTrue(a[i] >= 0 && a[i] < 10000);
		}

		boolean hasNegative = false;
		for (int i = 0; i < b.length; i++) {
			Assert.assertTrue(b[i] < 10000);
			hasNegative = b[i] < 0 ? true : hasNegative;
		}
		Assert.assertTrue(hasNegative);

	}

	/**
	 * Adds the int to array test.
	 */
	@Test
	public void addIntToArrayTest() {
		int[] a = new int[] { 1, 2, 3 };
		int[] result = AlgUtil.addIntToArray(a, 4);
		Assert.assertEquals(4, result.length);
		Assert.assertEquals(4, result[result.length - 1]);

	}

}
