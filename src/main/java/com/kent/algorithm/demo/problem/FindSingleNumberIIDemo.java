package com.kent.algorithm.demo.problem;

import java.util.Arrays;

import com.google.common.base.Joiner;
import com.kent.algorithm.Problem;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.FindSingleNumber;
import com.kent.algorithm.problem.FindSingleNumberII;
import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoType;

@Demo(type = DemoType.Problems, name="Find Single Number Space: O(1)")
public class FindSingleNumberIIDemo extends AbstractDemo {

	/** The problem. */
	private Problem<int[], Integer> problem;
	private int[] input;

	@Override
	protected void prepareDemo() {
		input = new int[]{1,1,5,5,2,2,3,3,3,4,5,4,6,6,1,6,7,2,4}; //7 is the answer
		problem = new FindSingleNumberII();
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

					"From http://oj.leetcode.com/problems/single-number-ii/",
					"",
					"Given an array of integers, every element appears THREE times except for one. Find that single one.",
					"Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?",
					"",
					"Solution:",
					"    ",
					"The requirement is space O(1), so bitwise operation is the direction to go. Integer is 32bits, declare an array with 32 elements, say a[32], the i-th element",
					"stores the sum of i-th bits of all numbers in given int[].",
					"",
					"Then get the mod (3) of each element in a[32], and finally combine the bits in a[32] to number again, to get the result."

						);
				//@formatter:on

		print(d);

	}
}
