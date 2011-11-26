package com.kent.algorithm;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.kent.algorithm.sorting.BubbleSort;
import com.kent.algorithm.sorting.InsertionSort;
import com.kent.algorithm.sorting.MergeSort;
import com.kent.algorithm.sorting.SelectionSort;
import com.kent.algorithm.sorting.Sorting;
import com.kent.test.BaseTest;

public class SortingTest extends BaseTest {
    private static final Logger LOG = Logger.getLogger(SortingTest.class);

    private int[] testArray;// = RandomUtil.getRandomIntArray(2200, 300);
    private int[] sortedArray;
    private final SortingOld sortingo = new SortingOld();
    private Sorting sorting;

    @Before
    public void initialize() {
	// testArray = Util.getRandomIntArray(2000, 3000);
	testArray = new int[] { 82, 2, 32, 768, 23, 106, 0, 23, 39, 34, 56, 16, 90, 17, 28 };
	sortedArray = new int[] { 0, 2, 16, 17, 23, 23, 28, 32, 34, 39, 56, 82, 90, 106, 768 };
	log.debug("Original Array:" + Arrays.toString(testArray));

    }

    @After
    public void printSortingResult() {
	log.debug("After sorting: " + Arrays.toString(testArray));
    }

    @Test
    public void testInsertionSort() {
	testInfo("insertSorting");
	sorting = new InsertionSort();
	sorting.sort(testArray);
	Assert.assertArrayEquals(sortedArray, testArray);
    }

    @Test
    public void testSelectionSort() {
	testInfo("selectionSort");
	sorting = new SelectionSort();
	sorting.sort(testArray);
	Assert.assertArrayEquals(sortedArray, testArray);
    }

    @Test
    public void testBubbleSort() {
	testInfo("bubbleSort");
	sorting = new BubbleSort();
	sorting.sort(testArray);
	Assert.assertArrayEquals(sortedArray, testArray);
    }

    @Test
    public void testMergeSort() {
	testInfo("MergeSort");
	sorting = new MergeSort();
	sorting.sort(testArray);
	Assert.assertArrayEquals(sortedArray, testArray);
    }

    @Test
    public void testQuickSort() {
	testInfo("quickSorting");
	sortingo.quickSort(testArray, 0, testArray.length - 1);
	Assert.assertArrayEquals(sortedArray, testArray);
    }

}
