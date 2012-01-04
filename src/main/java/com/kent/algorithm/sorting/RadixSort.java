package com.kent.algorithm.sorting;

import com.kent.algorithm.Sorting;

/**
 * Sort from the least significant digit (LSD).
 * <p>
 * From wikipedia:
 * </p>
 * Each key is first figuratively dropped into one level of buckets corresponding to the value of the rightmost digit. Each bucket preserves the
 * original order of the keys as the keys are dropped into the bucket. There is a one-to-one correspondence between the number of buckets and the
 * number of values that can be represented by a digit. Then, the process repeats with the next neighboring digit until there are no more digits to
 * process. In other words:
 * <ol>
 * <li>Take the least significant digit (or group of bits, both being examples of radices) of each key.</li>
 * <li>Group the keys based on that digit, but otherwise keep the original order of keys. (This is what makes the LSD radix sort a stable sort).</li>
 * <li>Repeat the grouping process with each more significant digit.</li>
 * </ol>
 * The sort in step 2 is usually done using bucket sort or counting sort, which are efficient in this case since there are usually only a small number
 * of digits.
 * <p>
 * Radix sort's efficiency is O(k·n) for n keys which have k or fewer digits. Note that this is not necessarily better than O(n·log(n)) when n is
 * sufficiently small.
 * </p>
 */
public class RadixSort extends Sorting {

	/** {@inheritDoc} */
	@Override
	public String getBigO() {
		return "O(n)";
	}

	/** {@inheritDoc} */
	@Override
	public int[] sort(int[] data) {
		final int d = getMaxNumberOfDigits(data);
		final int[] t = doRadixSort(data, d, 1);
		return t;
	}

	/**
	 * Do radix sort.
	 * 
	 * @param a
	 *            the array we want to sort
	 * @param d
	 *            the max number of digits
	 * @param s
	 *            the step
	 * @return the int[]
	 */
	public int[] doRadixSort(int[] a, int d, int s) {
		if (s > d) {
			return a;
		}

		final int[] da = new int[a.length]; // create an empty array to store the digit info of elements in a
		for (int i = 0; i < a.length; i++) {

			final int r = a[i] / (int) Math.pow(10, s - 1) % 10; // calculate the digit
			da[i] = r; // fill the digitArray

		}

		final int[] result = countingSortBasedOnDigit(a, da);
		s++;
		return doRadixSort(result, d, s);
	}

	/**
	 * Counting sort based on digit.
	 * 
	 * @param a
	 *            the array we want to sort
	 * @param da
	 *            the digit array we will use in countingSort
	 * @return the int[]
	 */
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
	 *            the a
	 * @return the max number of digits
	 */
	private int getMaxNumberOfDigits(int[] a) {
		final int max = getMaxAbs(a);
		return (int) Math.log10(max) + 1;
	}

	/**
	 * get the max abs of an array.
	 * 
	 * @param a
	 *            the a
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
