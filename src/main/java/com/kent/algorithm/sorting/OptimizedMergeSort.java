package com.kent.algorithm.sorting;

import java.util.Arrays;

import com.kent.util.AlgUtil;

public class OptimizedMergeSort extends MergeSort {
	private static final int INSERTIONSORT_THRESHOLD = 7;

	@Override
	public String getBigO() {
		return "O(?)";
	}

	@Override
	protected void mergeSorting(int[] data, int f, int t) {
		// if the array has 0 or 1 element, it is sorted.
		final int len = t - f + 1;
		if (len < INSERTIONSORT_THRESHOLD) {

			// print info
			if (isPrintSteps()) {
				System.out.print("InsertionSort : " + Arrays.toString(Arrays.copyOfRange(data, f, t + 1)) + " -> ");
			}

			int key;
			for (int i = f + 1; i <= t; i++) {
				key = data[i];
				int j = i - 1;
				for (; j >= f && data[j] > key; j--) {
					data[j + 1] = data[j];
				}
				data[j + 1] = key;
			}

			// print info
			if (isPrintSteps()) {
				AlgUtil.printIntArray(Arrays.copyOfRange(data, f, t + 1));
			}
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
}
