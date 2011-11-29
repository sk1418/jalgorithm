package com.kent.algorithm.misc;

import java.util.Arrays;

/**
 * find out counts of inversion pairs in an array using (n log n) algorithm, e.g. MergeSort
 * 
 * @author kent
 * 
 */
public class CountInversionPairs extends MiscAlgorithm<int[], Long> {

	private long counts = 0;

	@Override
	public Long execute(int[] data) {
		counts = 0;
		countInversions(data, 0, data.length - 1);
		return counts;
	}

	private void countInversions(final int[] data, int f, int t) {
		// if the array has 0 or 1 element, it is sorted.
		if (f == t) {
			return;
		}

		final int m = (f + t) / 2;
		countInversions(data, f, m);
		countInversions(data, m + 1, t);
		mergeAndCount(data, f, m, t);
	}

	private void mergeAndCount(int[] data, int from, int mid, int to) {
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
				counts += left.length - i;
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

	@Override
	public String output() {
		// TODO Auto-generated method stub
		return null;
	}

}
