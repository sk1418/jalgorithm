package com.kent.algorithm.demo.problem;

import java.util.Arrays;
import java.util.List;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.kent.algorithm.Problem;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.CheckPalindromeNumber;
import com.kent.algorithm.problem.FindLongestSubStrWithoutRepeatedChars;
import com.kent.algorithm.problem.PlusOne;
import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoType;
import com.kent.util.AlgUtil;

@Demo(type = DemoType.Problems, name="Check Palindrome Number")
public class CheckPalindromeNumberDemo extends AbstractDemo {

	/** The problem. */
	private Problem<Integer, Boolean> problem;

	private List<Integer> inputs =null;
	@Override
	protected void prepareDemo() {
		inputs = ImmutableList.of(-1, 0, 2345432, 100101, 1010101);
		problem = new CheckPalindromeNumber();
		problem.setPrintSteps(true);
	}

	@Override
	protected void specificDemo() {

		print("Space complexity:" + problem.getBigO());
		for (Integer i : inputs) {
			printLine("=", 0);
			print("Checking Integer: " + String.valueOf(i) + " ....");
			print("Result: " + problem.solve(i));
		}
	}

	@Override
	protected void warmingUp() {
		// warmingUp is not required
	}


	@Override
	protected void printDescription() {
//@formatter:off
			final String d = Joiner.on("\n").join(

				"From http://oj.leetcode.com/problems/palindrome-number",
				"",
				"Determine whether an integer is a palindrome. Do this without extra space.",
				"",
				"The requirement is space O(1), so we cannot convert number into String. ",
				"",
				"Solution",
				"    - return false if Negative number.",
				"    - check the first and last number, if they are same, if yes, chop them, then check again until the number ==0"

			);
			//@formatter:on
	print(d);

	}
}
