package com.kent.algorithm.problem;

import org.junit.Assert;
import org.junit.Test;

import com.kent.test.BaseTest;

public class SortingStringsWithTotalNCharsTest extends BaseTest {
	@Test
	public void testSolve() {
		final SortingStringsWithTotalNChars target = new SortingStringsWithTotalNChars();

		final String[] testArray = new String[] { "xzzzz", "a", "ab", "b", "bcd", "bcx", "zzzzz", "0xdf", "have", "Acfd", "Acff", "someday",
				"somebody", "Junit", "python", "panic", "linux", "linux-header" };
		final String[] sortedArray = new String[] { "0xdf", "Acfd", "Acff", "Junit", "a", "ab", "b", "bcd", "bcx", "have", "linux", "linux-header",
				"panic", "python", "somebody", "someday", "xzzzz", "zzzzz" };

		final String[] result = target.solve(testArray);
		Assert.assertArrayEquals(result, sortedArray);

	}
}
