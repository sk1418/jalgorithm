package com.kent.algorithm.problem;

import java.util.List;

import com.kent.algorithm.Problem;

/**
 * <p>
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.
 * </p>
 * <p>
 * The overall run time complexity should be O(log (m+n)).
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
		final int m = a.length;
		final int n = b.length;
		final int s = m + n;
		if (m == 0) {
			return simpleMedian(b);
		}
		if (n == 0) {
			return simpleMedian(a);
		}

		return findMedian(a, b, Math.max(0, (m + n) / 2 - n), Math.min(m - 1, (m + n) / 2), m, n);

	}

	private double findMedian(final int[] a, final int[] b, final int left, final int right, final int m, final int n) {
		if (left > right) {
			return findMedian(b, a, Math.max(0, (m + n) / 2 - m), Math.min(n - 1, (m + n) / 2), n, m);

		}
		final int i = (left + right) / 2;
		final int j = (m + n) / 2 - i - 1;
		System.out.println("i,j" + i + "," + j);
		if (j < n - 1 && a[i] > b[j + 1]) {
			return findMedian(a, b, left, i - 1, m, n);
		} else if (j >= 0 && a[i] < b[j]) {
			return findMedian(a, b, i + 1, right, m, n);
		} else {

			if ((m + n) % 2 == 1) {
				return a[i];
			} else if (i > 0) {
				final int pre = j < 0 ? a[i - 1] : Math.max(a[i - 1], b[j]);
				return (a[i] + pre) / 2.0;
			} else {
				return (a[i] + b[j]) / 2.0;
			}
		}

	}

	private double simpleMedian(final int A[]) {
		final int n = A.length;
		if (n % 2 == 1) {
			return A[n / 2];
		}
		return (A[n / 2 - 1] + A[n / 2]) / 2.0;
	}
}
