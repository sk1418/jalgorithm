package com.kent.util;

import junit.framework.Assert;

import org.junit.Test;

public class AlgUtilTest {
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

}
