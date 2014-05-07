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
 *     <b>Solution:</b>
 *     <p>
 *
 * The requirement is space O(1), so bitwise operation is the direction to go. Integer is 32bits, declare an array with 32 elements, say a[32], the i-th element
 * stores the sum of i-th bits of all numbers in given int[].
 *
 * Then get the mod (3) of each element in a[32], and finally combine the bits in a[32] to number again, to get the result.
 *     </p>
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

		//till here a[] stores the sum of bits,  in reverse order
		for (int b = 0; b < 32; b++) {
			x |= ((a[b] % 3) << b);
		}
		return x;
	}


}
