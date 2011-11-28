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
public class MergeSort extends Sorting {
    private static final Logger LOG = Logger.getLogger(MergeSort.class);

    private final int SENTINEL = Integer.MAX_VALUE;

    @Override
    public void sort(int[] data) {
	mergeSorting(data, 0, data.length - 1);
    }

    private void mergeSorting(int[] data, int f, int t) {

	// if the array has 0 or 1 element, it is sorted.
	if (f == t) {
	    return;
	}

	// partitioning the array into two sub-arrays
	final int m = (f + t) / 2;

	// sort
	mergeSorting(data, f, m);

	mergeSorting(data, m + 1, t);

	// merge
	mergeWithoutSentinel(data, f, m, t);
    }

    /**
     * A Merge approach using SENTINEL
     * 
     * @param data
     *            the array need to be done in Merge
     * @param from
     *            start idx
     * @param mid
     *            mid idx
     * @param to
     *            end idx
     */
    private void mergeWithSentinel(int[] data, int from, int mid, int to) {
	// merge two arrays
	final int[] left = Arrays.copyOfRange(data, from, mid + 1 + 1);
	final int[] right = Arrays.copyOfRange(data, mid + 1, to + 1 + 1);

	// add one infinitely great value at the end of each array
	left[left.length - 1] = SENTINEL;
	right[right.length - 1] = SENTINEL;

	int i = 0, j = 0;

	for (int k = from; k <= to; k++) {
	    if (left[i] <= right[j]) {
		data[k] = left[i];
		i++;
	    } else {
		data[k] = right[j];
		j++;
	    }
	}
	// LOG.debug("Step Result:" + Arrays.toString(data));
    }

    /**
     * A Merge approach without using SENTINEL
     * 
     * @param data
     * @param from
     * @param mid
     * @param to
     */
    private void mergeWithoutSentinel(int[] data, int from, int mid, int to) {
	// merge two arrays
	final int[] left = Arrays.copyOfRange(data, from, mid + 1);
	final int[] right = Arrays.copyOfRange(data, mid + 1, to + 1);

	int i = 0, j = 0; // idx of left and right arrays.
	int k = from; // idx of original array (data)

	while (i < left.length && j < right.length) {

	    if (left[i] <= right[j]) {
		data[k] = left[i];
		i++;
	    } else {
		data[k] = right[j];
		j++;
	    }
	    k++;
	}
	final boolean leftDone = i == left.length;
	final boolean rightDone = j == right.length;

	if (leftDone && rightDone) {
	    return;
	} else if (leftDone) {
	    while (j < right.length) {
		data[k] = right[j];
		j++;
		k++;
	    }
	} else {
	    while (i < left.length) {
		data[k] = left[i];
		k++;
		i++;
	    }
	}
	// LOG.debug("Step Result:" + Arrays.toString(data));
    }
}
