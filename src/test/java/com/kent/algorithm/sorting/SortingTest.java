package com.kent.algorithm.sorting;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.kent.algorithm.Sorting;
import com.kent.algorithm.SortingOld;
import com.kent.algorithm.sorting.BubbleSort;
import com.kent.algorithm.sorting.InsertionSort;
import com.kent.algorithm.sorting.MergeSort;
import com.kent.algorithm.sorting.SelectionSort;
import com.kent.test.BaseTest;

/**
 * The Class SortingTest.
 */
public class SortingTest extends BaseTest {

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(SortingTest.class);

	/** The test array. */
	private int[] testArray;// = RandomUtil.getRandomIntArray(2200, 300);

	/** The sorted array. */
	private int[] sortedArray;

	/** The sortingo. */
	private final SortingOld sortingo = new SortingOld();

	/** The sorting. */
	private Sorting sorting;

	/**
	 * Initialize.
	 */
	@Before
	public void initialize() {
		// testArray = Util.getRandomIntArray(2000, 3000);
		testArray = new int[] { 82, 2, 32, 768, 23, 106, 0, 23, 39, 34, 56, 16, 90, 17, 28 };
		sortedArray = new int[] { 0, 2, 16, 17, 23, 23, 28, 32, 34, 39, 56, 82, 90, 106, 768 };
		// log.debug("Original Array:" + Arrays.toString(testArray));

	}

	/**
	 * Prints the sorting result.
	 */
	@After
	public void printSortingResult() {
		// log.debug("After sorting: " + Arrays.toString(testArray));
	}

	/**
	 * Test insertion sort.
	 */
	@Test
	public void testInsertionSort() {
		testInfo("insertSorting");
		sorting = new InsertionSort();
		sorting.sort(testArray);
		Assert.assertArrayEquals(sortedArray, testArray);
	}

	/**
	 * Test selection sort.
	 */
	@Test
	public void testSelectionSort() {
		testInfo("selectionSort");
		sorting = new SelectionSort();
		sorting.sort(testArray);
		Assert.assertArrayEquals(sortedArray, testArray);
	}

	/**
	 * Test bubble sort.
	 */
	@Test
	public void testBubbleSort() {
		testInfo("bubbleSort");
		sorting = new BubbleSort();
		sorting.sort(testArray);
		Assert.assertArrayEquals(sortedArray, testArray);
	}

	/**
	 * Test merge sort.
	 */
	@Test
	public void testMergeSort() {
		testInfo("MergeSort");
		sorting = new MergeSort();
		sorting.sort(testArray);
		Assert.assertArrayEquals(sortedArray, testArray);
	}

	/**
	 * Test quick sort.
	 */
	@Test
	public void testQuickSort() {
		testInfo("quickSorting");
		sortingo.quickSort(testArray, 0, testArray.length - 1);
		Assert.assertArrayEquals(sortedArray, testArray);
	}

}
