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
		final CountingSort sorting = new CountingSort();
		sorting.setMaxValue(6);
		sorting.setPrintSteps(true);
		final int[] c = sorting.sort(testArray);
		Assert.assertArrayEquals(sortedArray, c);
	}

	@Test
	public void testRadixSort() {
		testArray = new int[] { 233, 442, 349, 102, 477, 35, 20, 200 };
		sortedArray = new int[] { 20, 35, 102, 200, 233, 349, 442, 477 };
		testInfo("RadixSort");
		final RadixSort sorting = new RadixSort();
		sorting.setPrintSteps(true);
		final int[] c = sorting.sort(testArray);
		Assert.assertArrayEquals(sortedArray, c);
	}
}
