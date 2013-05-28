package com.kent.algorithm.problem;

import com.kent.algorithm.Problem;

/**
 * <p>
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * 
 * For example,
 * 
 * <pre>
 * Given input array A = [1,1,2],
 * 
 * Your function should return length = 2, and A is now [1,2].
 * </pre>
 * 
 * </p>
 * 
 * 
 * <b>Solution/Algorithm</b>
 * 
 * <pre>
 * - create two pointers (uniq and checker) to index
 * - compare A[checker] to A[uniq], if not equal, save checker's value to A[++uniq]; 
 * - checker++, check again, until the end of the array
 * </pre>
 * 
 * @author kent
 * 
 */
public class RemoveDupsFromSortedArray extends Problem<int[], Integer> {

	@Override
	public String getBigO() {
		return "Time: O(n); Space O(1)";
	}

	@Override
	// double pointer solution
	public Integer solve(final int[] data) {
		if (data.length < 2) {
			return data.length;
		}

		int uniq = 0;
		int checker = 1;

		while (checker < data.length) {
			if (data[checker] != data[uniq]) {
				data[++uniq] = data[checker];
			}
			checker++;
		}

		return uniq + 1;
	}

}
