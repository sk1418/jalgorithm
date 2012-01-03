package com.kent.algorithm.demo.sorting;

import com.kent.algorithm.Sorting;
import com.kent.util.AlgUtil;

/**
 * The Class CountingSort.
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
		int[] count = new int[maxValue + 1]; // temp array
		int[] r = new int[data.length]; // result
		for (int i = 0; i < data.length; i++) {
			count[data[i]]++;
		}

		for (int j = 1; j < count.length; j++) {
			count[j] += count[j - 1];
		}
		if (isPrintSteps()) {
			AlgUtil.print("Sorting array: ");
			AlgUtil.printIntArray(data);
			AlgUtil.print("count  array: ");
			AlgUtil.printIntArray(count);
			AlgUtil.print("result array: ");
			AlgUtil.printIntArray(r);
			AlgUtil.println("");
		}

		for (int i = 0; i < data.length; i++) {
			r[count[data[i]] - 1] = data[i];
			count[data[i]]--;
			if (isPrintSteps()) {
				AlgUtil.print("count  array: ");
				AlgUtil.printIntArray(count);
				AlgUtil.print("result array: ");
				AlgUtil.printIntArray(r);
				AlgUtil.println("");
			}
		}

		return r;
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
