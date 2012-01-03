package com.kent.algorithm.sorting;

import com.kent.algorithm.Sorting;

public class RadixSort extends Sorting {

	@Override
	public String getBigO() {
		return "O(n)";
	}

	@Override
	public int[] sort(int[] data) {
		final int d = getMaxNumberOfDigits(data);
		final int[] t = doRadixSort(data, d, 1);
		return t;
	}

	public int[] doRadixSort(int[] a, int d, int s) {
		if (s > d) {
			return a;
		}

		final int[] da = new int[a.length]; // create an empty array to store the digit info of elements in a
		for (int i = 0; i < a.length; i++) {

			final int r = a[i] / (int) Math.pow(10.0, s - 1) % 10; // calculate the digit
			da[i] = r; // fill the digitArray

		}

		final int[] result = countingSortBasedOnDigit(a, da);
		s++;
		return doRadixSort(result, d, s);
	}

	private int[] countingSortBasedOnDigit(int[] a, int[] da) {
		final int[] c = new int[10]; // {0-9}
		final int[] r = new int[a.length]; // result
		for (final int e : da) {
			c[e]++;
		}
		for (int i = 1; i < 10; i++) {
			c[i] += c[i - 1];
		}

		for (int i = a.length - 1; i >= 0; i--) {
			r[c[da[i]] - 1] = a[i];
			c[da[i]]--;
		}
		return r;
	}

	/**
	 * get the max number of digits among all element in an array. i.e. {1,23,444,5123} return 4. since 5123 has 4 digits
	 * 
	 * @param a
	 * @return
	 */
	private int getMaxNumberOfDigits(int[] a) {
		final int max = getMaxAbs(a);
		return (int) Math.log10(max) + 1;
	}

	/**
	 * get the max abs of an array
	 * 
	 * @param a
	 * @return the max ABS
	 */
	private int getMaxAbs(int[] a) {
		int maxAbs = 0;
		for (final int e : a) {
			final int abs = Math.abs(e);
			maxAbs = abs > maxAbs ? abs : maxAbs;
		}
		return maxAbs;

	}

}
