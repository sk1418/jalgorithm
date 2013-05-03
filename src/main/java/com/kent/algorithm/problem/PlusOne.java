package com.kent.algorithm.problem;

import java.util.Arrays;

import com.kent.algorithm.Problem;

/**
 * <p>
 * Given a number represented as an array of digits, plus one to the number.
 * </p>
 * 
 * @author kent
 * 
 */
public class PlusOne extends Problem<int[], int[]> {

	@Override
	public String getBigO() {
		return "O(n)";
	}

	@Override
	public int[] solve(final int[] data) {
		for (int i = data.length - 1; i >= 0; i--) {
			if (data[i] < 9) {
				data[i]++;
				return data;
			} else {
				data[i] = 0;
			}
		}

		// if reach here, means all elements in array are 9
		final int[] result = Arrays.copyOf(data, data.length + 1);
		result[result.length - 1] = 0;
		result[0] = 1;
		return result;
	}

}
