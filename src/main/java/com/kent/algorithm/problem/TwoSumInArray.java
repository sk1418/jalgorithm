package com.kent.algorithm.problem;

import java.util.Arrays;

import com.kent.algorithm.Problem;

/**
 * <p>
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * </p>
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please
 * note that your returned answers (both index1 and index2) are not zero-based.
 * </p>
 * 
 * 
 * <p>
 * You may assume that each input would have exactly one solution.
 * </p>
 * 
 * <pre>
 *  Input: numbers={2, 7, 11, 15}, target=9
 *  Output: index1=1, index2=2
 * </pre>
 * 
 * 
 * @author kent
 */
public class TwoSumInArray extends Problem<int[], int[]> {

	/** {@inheritDoc} */
	@Override
	public String getBigO() {
		return "unknown";
	}

	/**
	 * @param the
	 *            input array, since this problem needs 1-based array, the index 0 is the target sum.
	 * */
	@Override
	public int[] solve(final int[] data) {
		final int[] result = new int[2];
		final int target = data[0];
		data[0] = Integer.MAX_VALUE;
		final int[] sorted = Arrays.copyOf(data, data.length);
		Arrays.sort(sorted);
		int t, end = sorted.length;
		for (int i = 1; i < end; i++) {
			t = sorted[i];

			for (int j = i + 1; j < end; j++) {
				if (t + sorted[j] == target) {
					// here find out the orignal index
					for (int x = 1; x < data.length; x++) {
						result[0] = data[x] == sorted[i] ? x : result[0];
						result[1] = data[x] == sorted[j] ? x : result[1];
						if (result[0] * result[1] > 0) {
							return result;
						}
					}
				}
				if (t + data[j] > target) {
					end = j;
					break;
				}
			}

		}
		// should not be here, since problem defined there is exactly one solution in input
		return result;
	}

}
