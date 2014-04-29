package com.kent.algorithm.problem;

import java.util.List;

import com.kent.algorithm.Problem;

/**
 * From http://oj.leetcode.com/problems/median-of-two-sorted-arrays/
 * <p>
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.
 * </p>
 * <p>
 * The overall run time complexity should be O(log (m+n)).
 * </p>
 * 
 * <p>
 * Solution: The basic idea is that if you are given two arrays A and B and know the length of each, you can check whether an element A[i] is the
 * median in constant time. Suppose that the median is A[i]. Since the array is sorted, it is greater than exactly i − 1 values in array A. Then if it
 * is the median, it is also greater than exactly
 * 
 * <pre>
 * j = n / 2 - (i - 1)
 * </pre>
 * 
 * elements in B. It requires constant time to check if
 * </p>
 * 
 * <pre>
 * B[j]<= A[i] <= B[j + 1].
 * </pre>
 * 
 * <p>
 * If A[i] is not the median, then depending on whether A[i] is greater or less than B[j] and B[j + 1], you know that A[i] is either greater than or
 * less than the median. Thus you can binary search for A[i] in O(lg n) worst-case time.
 * </p>
 * 
 * <p>
 * the above solution works when the total number of elements is odd. if n is even. The found median is the larger element, need to find out the
 * smaller element and do a average.
 * </p>
 * 
 * @author kent
 * 
 */
public class MedianOfTwoSortedArrays extends Problem<List<int[]>, Double> {

	@Override
	public String getBigO() {
		return "O( log(m+n) )";
	}

	@Override
	public Double solve(final List<int[]> data) {
		final int[] a = data.get(0);
		final int[] b = data.get(1);
		// init the variables
		final int m = a.length;
		final int n = b.length;
		final int s = m + n;
		if (m == 0) {
			return simpleMedian(b);
		}
		if (n == 0) {
			return simpleMedian(a);
		}

		return findMedian(a, b, Math.max(0, s / 2 - n), Math.min(m - 1, s / 2));

	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @param left
	 * @param right
	 * @return the found median
	 */
	private double findMedian(final int[] a, final int[] b, final int left, final int right) {
		final int m = a.length;
		final int n = b.length;
		final int s = m + n;
		if (left > right) {
			return findMedian(b, a, Math.max(0, s / 2 - m), Math.min(n - 1, s / 2));

		}
		final int i = (left + right) / 2;
		final int j = s / 2 - i - 1;
		if (j >= 0 && a[i] < b[j]) {
			return findMedian(a, b, i + 1, right);
		}
		if (j < n - 1 && a[i] > b[j + 1]) {
			return findMedian(a, b, left, i - 1);
		}
		if (s % 2 == 1) {
			return a[i];
		} else if (i > 0) {
			final int pre = j < 0 ? a[i - 1] : Math.max(a[i - 1], b[j]);
			return (a[i] + pre) / 2.0;
		} else {
			return (a[i] + b[j]) / 2.0;
		}

	}

	private double simpleMedian(final int a[]) {
		final int n = a.length;
		if (n % 2 == 1) {
			return a[n / 2];
		}
		return (a[n / 2 - 1] + a[n / 2]) / 2.0;
	}
}
