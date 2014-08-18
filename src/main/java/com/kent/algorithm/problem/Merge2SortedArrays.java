package com.kent.algorithm.problem;

import java.util.Map;

import com.kent.algorithm.Problem;

/**
 * From https://oj.leetcode.com/problems/merge-sorted-array/
 * <p>
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * <p/>
 * </p>
 * <p>
 * You may assume that A has enough space (size that is greater or equal to m + n)
 * to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
 * <p/>
 * </p>
 * <p/>
 * <pre>
 * Inputs:
 * A[]  - the array A
 * m    - the size of sorted elements in A
 * B[]  - the array B
 * n    - the size of B
 *
 * >Solution<
 * - merge from the rear of both arrays
 *
 * </pre>
 *
 * @author Kent
 */

public class Merge2SortedArrays extends Problem<Map<String, Object>, int[]> {

	@Override
	public String getBigO() {
		return "O(m+n); space: O(1)";
	}

	@Override
	public int[] solve(Map<String, Object> input) {
		//get parameters
		int[] A = (int[]) input.get("A");
		int[] B = (int[]) input.get("B");
		int m = (Integer) input.get("m");
		int n = (Integer) input.get("n");

		int t = m + n - 1;// the last index of merged array
		m--; //the index of last element in A
		n--; //the index of last element in B

		while (m >= 0 && n >= 0) {
			if (A[m] > B[n]) {
				A[t--] = A[m--];
			}
			else {
				A[t--] = B[n--];
			}
		}
		//if there is left element in B
		while (n >= 0) {
			A[t--] = B[n--];
		}

		return A;
	}

}
