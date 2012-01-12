package com.kent.algorithm.sorting;

import java.util.LinkedList;
import java.util.List;

import com.kent.algorithm.Sorting;
import com.kent.util.AlgUtil;

/**
 * <p>
 * BucketSort
 * </p>
 * <p>
 * </p>
 * 
 */
public class BucketSort extends Sorting {

	/** The max value. */
	private int maxValue;
	private int minValue;
	private int interval = 10;

	/** {@inheritDoc} */
	@Override
	public String getBigO() {
		return "O(n)";
	}

	/** {@inheritDoc} */
	@Override
	public int[] sort(int[] data) {
		final int numberOfBuckets = (maxValue - minValue) / interval + 1;
		final List<Integer>[] buckets = new List[numberOfBuckets];
		for (int i = 0; i < numberOfBuckets; i++) {
			buckets[i] = new LinkedList<Integer>();
		}

		// scatter
		for (final int e : data) {
			buckets[e / interval].add(e);
		}
		// gather: put the distributed linkedlist elements back to original array, then do insertSort on the complete array.
		int i = 0;
		for (int b = 0; b < numberOfBuckets; b++) {
			for (final int e : buckets[b]) {
				data[i++] = e;
			}
		}

		// insertion Sort on data
		int k;
		for (int x = 1; x < data.length; x++) {
			k = data[x];
			int j = x - 1;
			while (j >= 0 && data[j] > k) {
				data[j + 1] = data[j];
				j--;
			}
			data[j + 1] = k;

		}

		return data;
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

	public void setMinValue(int minValue) {
		this.minValue = minValue;
	}

}
