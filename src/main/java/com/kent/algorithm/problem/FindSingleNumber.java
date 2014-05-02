package com.kent.algorithm.problem;

import java.util.HashSet;
import java.util.Set;

import com.kent.algorithm.Problem;

/**
 * From http://oj.leetcode.com/problems/single-number/
 * <p>
 *     Given an array of integers, every element appears twice except for one. Find that single one.
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * </p>
 *
 * <p>
 *     <b>Solution:</b>
 *
 * Since the case of the occurrences of a number in array has only two possibilities, double or single.  It is easy to find out the single
 * number. E.g. using a Set or Map to add/remove the numbers. However this will at least need n/2 storage. Now comes the interesting part: O(1) space
 * complexity!
 *
 * XOR is the solution. Since XOR (^) has the characteristic:
 * <pre>
 *     A ^ B ^ C ^ D ^ A ^ B ^ C = D
 *     and
 *     X ^ 0 = X
 * </pre>
 *
 * </p>
 * @author kent
 * 
 */
public class FindSingleNumber extends Problem<int[], Integer> {

	@Override
	public String getBigO() {
		return "O(n)";
	}

	@Override
	public Integer solve(final int[] data) {
		assert data!=null;
		int x = 0;
		for (int i : data) {
			x ^= i;
		}
		return x;
	}


}
