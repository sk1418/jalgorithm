package com.kent.algorithm;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class Sorting.
 */
public class SortingOld {

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(SortingOld.class);

	/**
	 * Quick sort.
	 * 
	 * @param data
	 *            the data
	 * @param left
	 *            the left
	 * @param right
	 *            the right
	 */
	public void quickSort(int[] data, int left, int right) {

		final int privot = data[left];
		// log.debug("Using "+privot+" as KEY");
		int pos = left;
		int i = left - 1;
		int j = right + 1;
		while (i < j) {
			while (--j > left && data[j] > privot) {
				;
			}
			if (i < j) {
				swap(data, j, pos);
			}
			pos = j;
			// log.debug("<- After swap: " + Arrays.toString(data));
			while (++i < right && data[i] < privot) {
				;
			}
			if (i < j) {
				swap(data, i, pos);
			}
			pos = i;
			// log.debug("-> After swap: " + Arrays.toString(data));
		}
		// log.debug(">>> step over <<<");
		if (left < pos) {
			quickSort(data, left, pos - 1);
		}
		if (right > pos) {
			quickSort(data, pos + 1, right);
		}

	}

	/**
	 * Insert sort.
	 * 
	 * @param data
	 *            the data
	 */
	public void insertSort(int[] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = i + 1; j < data.length; j++) {
				if (data[j] < data[i]) {
					swap(data, j, i);
				}
			}
		}
		LOG.debug("Insert Sorting done");
	}

	/**
	 * helper method, swap the two element in an int array.
	 * 
	 * @param data
	 *            , the int array
	 * @param i
	 *            index i
	 * @param j
	 *            index j
	 */
	private static void swap(int[] data, int i, int j) {
		// log.debug("swap: Array["+i+"]:"+data[i] +
		// " and Array["+j+"]:"+data[j]);
		final int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}
}
