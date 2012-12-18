package com.kent.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.Assert;
import org.junit.Test;

//import org.apache.log4j.Logger;

/**
 * The Class AlgUtilTest.
 */
public class AlgUtilTest {
	private static final Logger log = LoggerFactory.getLogger(AlgUtilTest.class);

	/**
	 * Gets the random int array test.
	 */
	@Test
	public void testGetRandomIntArray() {
		final int[] a = AlgUtil.getRandomIntArray(100, 10000, false);
		final int[] b = AlgUtil.getRandomIntArray(100, 20, true);

		for (final int element : a) {
			Assert.assertTrue(element >= 0 && element < 10000);
		}

		boolean hasNegative = false;
		for (final int element : b) {
			Assert.assertTrue(element < 10000);
			hasNegative = element < 0 ? true : hasNegative;
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

	@Test
	public void testReverseIntArray() {
		final int[] a = new int[] { 1, 2, 3, 4, 5, 6 };
		final int[] b = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		final int[] resultA = new int[] { 6, 5, 4, 3, 2, 1 };
		final int[] resultB = new int[] { 7, 6, 5, 4, 3, 2, 1 };
		AlgUtil.reverseIntArray(a);
		AlgUtil.reverseIntArray(b);
		Assert.assertArrayEquals(a, resultA);
		Assert.assertArrayEquals(b, resultB);
	}

	@Test
	public void testIt2() {
		final String s = "My name is not eugene. my pet name is not eugene.";
		final String tmp = s.toLowerCase().replaceAll("[^a-zA-Z]", " ");// here we need the placeholder (blank)
		final String w1 = "my "; // leave a blank at the end to avoid those words e.g. "myself", "myth"..
		final String w2 = "eugene ";// same as above
		final List<Integer> l1 = getList(tmp, w1); // indexes list
		final List<Integer> l2 = getList(tmp, w2);
		int min = Integer.MAX_VALUE;
		final int[] idx = new int[] { 0, 0 };

		// loop to find out the result
		for (final int i : l1) {
			for (final int j : l2) {
				if (Math.abs(j - i) < min) {
					final int x = j - i;
					min = Math.abs(j - i);
					idx[0] = j - i > 0 ? i : j;
					idx[1] = j - i > 0 ? j + w2.length() + 2 : i + w1.length() + 2;
				}
			}

		}

		System.out.println("indexes: " + Arrays.toString(idx));
		System.out.println("result: " + s.substring(idx[0], idx[1]));
	}

	private List<Integer> getList(final String input, final String search) {
		String t = new String(input);
		final List<Integer> list = new ArrayList<Integer>();
		int tmp = 0;
		while (t.length() > 0) {
			final int x = t.indexOf(search);

			if (x < 0 || x > t.length()) {
				break;
			}
			tmp += x;
			list.add(tmp);
			t = t.substring(search.length() + x);

		}
		return list;

	}
}
