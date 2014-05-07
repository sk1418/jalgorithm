package com.kent.algorithm.problem;

import com.kent.algorithm.Problem;

/**
 * From http://oj.leetcode.com/problems/single-number-ii/
 * <p>
 *     Given an array of integers, every element appears THREE times except for one. Find that single one.
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * </p>
 *
 * <p>
 *     <b>Solution:</b>
 *
 * @author kent
 * 
 */
public class FindSingleNumberII extends Problem<int[], Integer> {

	@Override
	public String getBigO() {
		return "O(n)";
	}

	@Override
	public Integer solve(final int[] data) {
		assert data!=null;
		int[] a = new int[32] ;
		int x = 0;
		for (int i : data) {
			for (int b = 0; b < 32; b++) {
			a[b] += ((i >> b) & 1);
			}
		}

		//till here a[] stores the big digits of sums in reverse order
		for (int b = 0; b < 32; b++) {
			x |= ((a[b] % 3) << b);
		}
		return x;
	}


}
