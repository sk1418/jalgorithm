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
	public void testGetRandomIntArray() {
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
	public void testAddIntToArray() {
		final int[] a = new int[] { 1, 2, 3 };
		final int[] result = AlgUtil.appendIntArray(a, 4);
		Assert.assertEquals(4, result.length);
		Assert.assertEquals(4, result[result.length - 1]);

	}

	@Test
	public void testPrintHeap() {
		final int[] testArray = new int[] { 82, 2, 32, 768, 23, 106, 0, 23, 39, 34, 56, 16, 90, 17, 28, 48, 88, 99, 100, 120, 8, 27, 31 };
		final int[] testArray2 = new int[] { 82, 2 };
		AlgUtil.printBinaryTree(testArray, testArray.length, 6);
		AlgUtil.printBinaryTree(testArray2, testArray2.length, 1);
	}

}
