package com.kent.algorithm.sorting;

import com.kent.algorithm.Sorting;
import com.kent.util.AlgUtil;

/**
 * <p>
 * Counting sort assumes that each of the elements is an integer in the range 1 to k, for some integer k. When k = O(n), the Counting-sort runs in
 * O(n) time. The basic idea of Counting sort is to determine, for each input elements x, the number of elements less than x. This information can be
 * used to place directly into its correct position. For example, if there 17 elements less than x, than x belongs in output position 18.
 * </p>
 * <p>
 * In the code for Counting sort, we are given array A[1 . . n] of length n. We required two more arrays, the array B[1 . . n] holds the sorted output
 * and the array c[1 . . k] provides temporary working storage.
 * </p>
 * 
 */
public class CountingSort extends Sorting {

	/** The max value. */
	private int maxValue;

	/** {@inheritDoc} */
	@Override
	public String getBigO() {
		return "O(n)";
	}

	/** {@inheritDoc} */
	@Override
	public int[] sort(int[] data) {
		final int[] count = new int[maxValue + 1]; // temp array
		final int[] r = new int[data.length]; // result
		for (int i = 0; i < data.length; i++) {
			count[data[i]]++;
		}

		for (int j = 1; j < count.length; j++) {
			count[j] += count[j - 1];
		}
		// print step
		printStep(data, count, r);

		for (int i = 0; i < data.length; i++) {
			r[count[data[i]] - 1] = data[i];
			count[data[i]]--;
			// print step
			printStep(data, count, r);
		}

		return r;
	}

	/**
	 * print the step info
	 * 
	 * @param data
	 * @param count
	 * @param r
	 */
	private void printStep(int[] data, int[] count, int[] r) {
		if (isPrintSteps()) {
			AlgUtil.print("    original: ");
			AlgUtil.printIntArray(data);
			AlgUtil.print("count  array: ");
			AlgUtil.printIntArray(count);
			AlgUtil.print("result array: ");
			AlgUtil.printIntArray(r);
			AlgUtil.println("");
		}
	}

	/**
	 * Sets the max value.
	 * 
	 * @param maxValue
	 *            the new max value
	 */
	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}

}
