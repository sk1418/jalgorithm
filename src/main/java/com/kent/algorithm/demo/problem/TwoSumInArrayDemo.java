package com.kent.algorithm.demo.problem;

import java.util.Arrays;
import java.util.Map;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.TwoSumInArrayII;
import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoType;
import com.kent.util.AlgUtil;

@Demo(type = DemoType.Problems, name="Find Two Sum in Array")
public class TwoSumInArrayDemo extends AbstractDemo {
	private Map<String, Object> inputMap1;
	private Map<String, Object> inputMap2;

	/** The problem. */
	private TwoSumInArrayII problem;

	@Override
	protected void prepareDemo() {
		inputMap1 = Maps.newHashMapWithExpectedSize(2);
		inputMap2 = Maps.newHashMapWithExpectedSize(2);

		inputMap1.put("array", new int[] { 150, 24, 79, 50, 88, 345, 3 });
		inputMap1.put("target", 200);
		// input two has duplicated elements
		inputMap2.put("array", new int[] { 2, 1, 9, 4, 4, 56, 90, 3 });
		inputMap2.put("target", 8);
		problem = new TwoSumInArrayII();
	}

	@Override
	protected void specificDemo() {

		print("Time complexity:" + problem.getBigO());
		doJob(inputMap1);
		doJob(inputMap2);
	}

	@Override
	protected void warmingUp() {
		// warmingUp is not required
	}

	/**
	 * Do job.
	 * 
	 * @param a
	 *            the a
	 */
	private void doJob(final Map<String, Object> inputMap) {
		final int[] a = (int[]) inputMap.get("array");
		final int target = (Integer) inputMap.get("target");

		print("\n\narray with " + a.length + " elements:");
		if (a.length == SMALL_ARRAY_SIZE) {
			print("Array: " + Arrays.toString(a));
		}
		print("Sum target: " + target);
		print(AlgUtil.repeatString("=", 50));

		stopwatch.start();
		final int[] result = problem.solve(inputMap);
		stopwatch.stop();
		print("Max Sub-Array found:");
		print("start idx:" + result[0]);
		print("end idx  :" + result[1]);
		print(AlgUtil.repeatString("=", 50));
		print(stopwatch.readAsString());
		stopwatch.reset();
	}

	@Override
	protected void printDescription() {
		//@formatter:off
		final String d =Joiner.on("\n").join(
				"Given an array of integers, find two numbers such that they add up to a specific target number.",
				"",
				"The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please",
				"note that your returned answers (both index1 and index2) are not zero-based.",
				"",
				"",
				"You may assume that each input would have exactly one solution.",
				"",
				"",
				"Input: numbers={2, 7, 11, 15}, target=9",
				"Output: index1=1, index2=2",
				"",
				"= Solution = ",
				"  From the first element, add the (target - element[i] ) as key, index (i) as value into a Hashmap ",
				"  From the 2nd element, if it is in the Hashmap as key, we got answer. else put it into Hashmap as same as above step."

				);
		//@formatter:on

		print(d);

	}
}
