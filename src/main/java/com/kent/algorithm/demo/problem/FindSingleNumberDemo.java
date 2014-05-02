package com.kent.algorithm.demo.problem;

import java.util.Arrays;
import java.util.List;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import com.kent.algorithm.Problem;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.FindLongestSubStrWithoutRepeatedChars;
import com.kent.algorithm.problem.FindSingleNumber;

public class FindSingleNumberDemo extends AbstractDemo {

	/** The problem. */
	private Problem<int[], Integer> problem;
	private int[] input;

	@Override
	protected void prepareDemo() {
		input = new int[]{1,5,2,3,3,4,5,6,1,6,7,2,4}; //7 is the answer
		problem = new FindSingleNumber();
		problem.setPrintSteps(true);
	}

	@Override
	protected void specificDemo() {

		print("Time complexity:" + problem.getBigO());
		print("Space complexity: O(1)");
		print(String.format("Processing array '%s', result is: %d", Arrays.toString(input), problem.solve(input)));
	}

	@Override
	protected void warmingUp() {
		// warmingUp is not required
	}


	@Override
	protected void printDescription() {
//@formatter:off
			final String d = Joiner.on("\n").join(

					"From http://oj.leetcode.com/problems/single-number/",
					"",
					"Given an array of integers, every element appears twice except for one. Find that single one.",
					"Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?",
					"",
					"Solution:",
					"",
					"Since the case of the occurrences of a number in array has only two possibilities, double or single.  It is easy to find out the single",
					"number. E.g. using a Set or Map to add/remove the numbers. However this will at least need n/2 storage. Now comes the interesting part: O(1) space",
					"complexity!",
					"",
					"XOR is the solution. Since XOR (^) has the characteristic:",
					"",
					"    A ^ B ^ C ^ D ^ A ^ B ^ C = D",
					"    and",
					"    X ^ 0 = X"
						);
				//@formatter:on

		print(d);

	}
}
