package com.kent.algorithm.problem;

import java.util.Arrays;
import java.util.Map;

import com.kent.algorithm.Problem;

/**
 * From http://oj.leetcode.com/problems/two-sum/
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
public class TwoSumInArray extends Problem<Map<String, Object>, int[]> {

	/** {@inheritDoc} */
	@Override
	public String getBigO() {
		return "O(nlogn+n)";
	}

	/**
	 * @param The
	 *            input
	 * 
	 *            <pre>
	 * map{"target":int, "array":int[]}
	 * </pre>
	 * 
	 *            The solution in TwoSumInArrayII is better.
	 * */
	@Override
	public int[] solve(final Map<String, Object> input) {
		final int target = (Integer) input.get("target");
		final int[] data = (int[]) input.get("array");
		final int[] result = new int[2];
		final int[] sorted = Arrays.copyOf(data, data.length);
		Arrays.sort(sorted);
		int t, end = sorted.length;
		for (int i = 0; i < end; i++) {
			t = sorted[i];

			for (int j = i + 1; j < end; j++) {
				if (t + sorted[j] == target) {
					// here find out the original index
					for (int x = 0; x < data.length; x++) {
						if (result[0] * result[1] > 0) {
							if (result[0] > result[1]) {
								final int tmp = result[0];
								result[0] = result[1];
								result[1] = tmp;
							}
							return result;
						}
						if (result[0] == 0 && data[x] == sorted[i]) {
							result[0] = x + 1;
							if (needReturn(result)) {
								return result;
							} else {
								continue;
							}
						}
						if (result[1] == 0 && data[x] == sorted[j]) {
							result[1] = x + 1;
							if (needReturn(result)) {
								return result;
							} else {
								continue;
							}
						}
					}
				}
				if (t + sorted[j] > target) {
					end = j;
					break;
				}
			}

		}
		// should not be here, since problem defined there is exactly one solution in input
		return result;
	}

	/**
	 * check if two indexes are both set, also sort the two indexes.
	 * 
	 * @param result
	 * @return
	 */
	private boolean needReturn(final int[] result) {
		if (result[0] * result[1] > 0) {
			if (result[0] > result[1]) {
				final int tmp = result[0];
				result[0] = result[1];
				result[1] = tmp;
			}
			return true;
		}
		return false;
	}
}
