package com.kent.algorithm.sorting;

import com.kent.algorithm.Sorting;
import com.kent.util.AlgUtil;

/**
 * 
 * <b>Quicksort</b><br/>
 * <p>
 * Divid-And-Conquer algorithm.
 * 
 * Partitioning is the key part.
 * </p>
 * 
 * 
 * <ol>
 * <li>select the last element(r) as Privot.</li>
 * <li>all elements with index 0->i are smaller than privot, and all elements with index i-(r-1) are greater than privot</li>
 * <li>recursively partitioning, will finish the sorting.</li>
 * </ol>
 * <p>
 * 
 * <br/>
 * <b>Time complexity:</b>
 * 
 * <br/>
 * worst case:O(n^2) <br/>
 * average O(nlogn)
 * </p>
 * 
 * @author kent
 * 
 */
public class QuickSort extends Sorting {

	/** {@inheritDoc} */
	@Override
	public String getBigO() {
		return "O(n^2)-O(nlog(n))";
	}

	/** {@inheritDoc} */
	@Override
	public void sort(final int[] data) {
		quickSort(data, 0, data.length - 1);

	}

	/**
	 * do Quick sort.
	 * 
	 * @param a
	 *            the array need to be sorted
	 * @param p
	 *            the p the start index of sorting
	 * @param r
	 *            the r the end index of sorting
	 */
	public void quickSort(final int[] a, final int p, final int r) {
		final int q = patition(a, p, r);
		// print step info
		if (isPrintSteps()) {
			AlgUtil.printIntArray(a);
		}
		if (q > p) {
			quickSort(a, p, q - 1);
		}
		if (q < r) {
			quickSort(a, q + 1, r);
		}
	}

	/**
	 * Patition. Key part of quickSort algorithm
	 * 
	 * @param a
	 *            the a the array
	 * @param p
	 *            the p start index
	 * @param r
	 *            the r end index
	 * @return the partition index.
	 */
	private int patition(final int[] a, final int p, final int r) {

		// set the last element as privot
		final int privot = a[r];
		int i = p - 1, j = p;
		for (; j < r; j++) {
			if (a[j] < privot) {
				i++;
				AlgUtil.swap(a, i, j);
			}
		}
		// swap a[i+1] and privot
		AlgUtil.swap(a, i + 1, r);
		return i + 1;
	}

}
