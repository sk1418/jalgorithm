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

	@Test
	public void testBucketSort() {
		testArray = new int[] { 85, 12, 2, 22, 33, 44, 55, 66, 77, 87, 81, 67, 83, 89, 82, 88, 86, 84, 88, 99 };
		sortedArray = new int[] { 2, 12, 22, 33, 44, 55, 66, 67, 77, 81, 82, 83, 84, 85, 86, 87, 88, 88, 89, 99 };
		testInfo("BucketSort");
		final BucketSort sorting = new BucketSort();
		sorting.setMaxValue(100);
		sorting.setMinValue(1);
		sorting.setNumberOfElements(20);
		sorting.setPrintSteps(true);
		final int[] c = sorting.sort(testArray);
		Assert.assertArrayEquals(sortedArray, c);
	}
}
