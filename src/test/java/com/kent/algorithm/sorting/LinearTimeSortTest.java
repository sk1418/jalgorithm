package com.kent.algorithm.sorting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.kent.test.BaseTest;

public class LinearTimeSortTest extends BaseTest {
	/** The test array. */
	private int[] testArray;

	/** The sorted array. */
	private int[] sortedArray;

	@Before
	public void initialize() {
	}

	@Test
	public void testCountingSort() {
		testArray = new int[] { 3, 2, 4, 1, 3, 4, 0, 6, 0, 2, 1, 4 };
		sortedArray = new int[] { 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 4, 6 };
		testInfo("CountingSort");
		CountingSort sorting = new CountingSort();
		sorting.setMaxValue(6);
		sorting.setPrintSteps(true);
		int[] c = sorting.sort(testArray);
		Assert.assertArrayEquals(sortedArray, c);
	}
}
