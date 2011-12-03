package com.kent.algorithm.sorting;

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
			int key;
			for (int i = f + 1; i <= t; i++) {
				key = data[i];
				int j = i - 1;
				for (; j >= f && data[j] > key; j--) {
					data[j + 1] = data[j];
				}
				data[j + 1] = key;
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
