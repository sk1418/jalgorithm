package com.kent.algorithm.sorting;

import java.util.Arrays;

import org.apache.log4j.Logger;

public class MergeSort implements Sorting {
    private static final Logger LOG = Logger.getLogger(MergeSort.class);
    private int[] tmp;

    @Override
    public void sort(int[] data) {
	tmp = new int[data.length];
	mergeSorting(data, 0, data.length - 1);
	// data = tmp;
    }

    private void mergeSorting(int[] data, int f, int t) {

	// if the array has 0 or 1 element, it is sorted.
	if (f == t)
	    return;

	// partitioning the array into two sub-arrays
	int m = (f + t) / 2;

	// sort
	mergeSorting(data, f, m);
	mergeSorting(data, m + 1, t);

	// merge two arrays
	int[] left = Arrays.copyOfRange(data, f, m + 1 + 1);
	int[] right = Arrays.copyOfRange(data, m + 1, t + 1 + 1);
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
