package com.kent.algorithm.sorting;

import java.util.Arrays;

import org.apache.log4j.Logger;

/**
 * <b>Merge sort</b> is typical in Divide and Conquer way to solve sorting problem.<br/>
 * <ol>
 * <li>If the list is of length 0 or 1, then it is already sorted. Otherwise:</li>
 * <li>Divide the unsorted list into two sublists of about half the size.</li>
 * <li>Sort each sublist recursively by re-applying the merge sort.</li>
 * <li>Merge the two sublists back into one sorted list.</li>
 * </ol>
 * <b>Time complexity:</b> O(n log n)
 * </p>
 * 
 * @author kent
 * 
 */
public class MergeSort implements Sorting {
    private static final Logger LOG = Logger.getLogger(MergeSort.class);

    @Override
    public void sort(int[] data) {
	mergeSorting(data, 0, data.length - 1);
    }

    private void mergeSorting(int[] data, int f, int t) {

	// if the array has 0 or 1 element, it is sorted.
	if (f == t)
	    return;

	// partitioning the array into two sub-arrays
	final int m = (f + t) / 2;

	// sort
	mergeSorting(data, f, m);
	mergeSorting(data, m + 1, t);

	// merge two arrays
	final int[] left = Arrays.copyOfRange(data, f, m + 1 + 1);
	final int[] right = Arrays.copyOfRange(data, m + 1, t + 1 + 1);

	// add one infinitely great value at the end of each array
	left[left.length - 1] = Integer.MAX_VALUE;
	right[right.length - 1] = Integer.MAX_VALUE;

	int i = 0, j = 0;

	for (int k = f; k <= t; k++) {
	    if (left[i] <= right[j]) {
		data[k] = left[i];
		i++;
	    } else {
		data[k] = right[j];
		j++;
	    }
	}

	// LOG.debug("result:" + Arrays.toString(data));

    }
}
