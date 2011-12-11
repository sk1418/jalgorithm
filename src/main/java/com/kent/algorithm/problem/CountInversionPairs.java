package com.kent.algorithm.problem;

import java.util.Arrays;

/**
 * find out counts of inversion pairs in an array using (n log n) algorithm, e.g. MergeSort
 * 
 * @author kent
 * 
 */
public class CountInversionPairs extends Problem<int[], Long> {

	/** The counts. */
	private long counts = 0;

	@Override
	protected StringBuffer getDescription() {
		final StringBuffer sb = new StringBuffer();
		sb.append("test");
		return sb;
	}

	@Override
	public String getBigO() {
		return "O(nlog(n))";
	}

	/** {@inheritDoc} */
	@Override
	public Long solve(int[] data) {
		// keep the original array
		final int[] arrayCp = new int[data.length];
		System.arraycopy(data, 0, arrayCp, 0, data.length);
		counts = 0;
		countInversions(arrayCp, 0, arrayCp.length - 1);
		return counts;
	}

	/**
	 * Count inversions.
	 * 
	 * @param data
	 *            the data
	 * @param f
	 *            the f
	 * @param t
	 *            the t
	 */
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

	/**
	 * Merge and count.
	 * 
	 * @param data
	 *            the data
	 * @param from
	 *            the from
	 * @param mid
	 *            the mid
	 * @param to
	 *            the to
	 */
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

}
