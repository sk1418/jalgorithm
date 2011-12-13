package com.kent.algorithm.problem;

public class BinarySearchProblem extends Problem<int[][], Integer> {

	@Override
	public Integer solve(int[][] data) {
		final int[] array = data[0]; // the array
		final int e = data[1][0]; // the integer we are searching for

		return binarySearch(array, 0, array.length - 1, e);
	}

	/**
	 * making this method public for other problems.
	 * 
	 * @param a
	 * @param start
	 * @param end
	 * @param v
	 * @return
	 */
	public int binarySearch(int[] a, int start, int end, int v) {
		if (start == end) {
			return a[start] == v ? start : -1;
		}
		if (v < a[start] || v > a[end]) {
			return -1;
		}
		final int mid = (end + start) / 2;
		if (a[mid] == v) {
			return mid;
		} else {
			return v > a[mid] ? binarySearch(a, mid + 1, end, v) : binarySearch(a, start, mid - 1, v);
		}

	}

	@Override
	public String getBigO() {
		return "O(logn)";
	}
}
