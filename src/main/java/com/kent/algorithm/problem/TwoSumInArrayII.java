package com.kent.algorithm.problem;

import java.util.HashMap;
import java.util.Map;

public class TwoSumInArrayII extends TwoSumInArray {

	@Override
	public String getBigO() {
		return "O(n)";
	}

	@Override
	public int[] solve(final Map<String, Object> input) {
		final int target = (Integer) input.get("target");
		final int[] numbers = (int[]) input.get("array");
		final int[] result = new int[2];
		final Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i <= numbers.length; i++) {
			if (map.containsKey(numbers[i])) {
				result[0] = map.get(numbers[i]) + 1;
				result[1] = i + 1;
				return result;
			} else {
				map.put(target - numbers[i], i);
			}
		}
		return result;
	}

}
