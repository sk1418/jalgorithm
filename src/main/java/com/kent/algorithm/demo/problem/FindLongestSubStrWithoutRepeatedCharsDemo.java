package com.kent.algorithm.demo.problem;

import java.util.Arrays;
import java.util.List;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.kent.algorithm.Problem;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.FindLongestSubStrWithoutRepeatedChars;
import com.kent.algorithm.problem.PlusOne;
import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoType;
import com.kent.util.AlgUtil;

@Demo(type = DemoType.Problems, name="Longest Substr no-Repeated Chars")
public class FindLongestSubStrWithoutRepeatedCharsDemo extends AbstractDemo {

	/** The problem. */
	private Problem<String, Integer> problem;
	private List<String> inputs;

	@Override
	protected void prepareDemo() {
		inputs = ImmutableList.of("aaaaaa", "abcdeacxyzm", "");
		problem = new FindLongestSubStrWithoutRepeatedChars();
		problem.setPrintSteps(true);
	}

	@Override
	protected void specificDemo() {

		print("Time complexity:" + problem.getBigO());

		for (String s : inputs) {
			printLine("=", 0);
			print(String.format("Processing string '%s', result is: %d", s, problem.solve(s)));
		}
	}

	@Override
	protected void warmingUp() {
		// warmingUp is not required
	}


	@Override
	protected String demoDescription() {
//@formatter:off
			return Joiner.on("\n").join(

					"From http://oj.leetcode.com/problems/longest-substring-without-repeating-characters/",
					"",
					"Given a string, find the length of the longest substring without repeating characters.",
					"For example, the longest substring without repeating letters for \"abcabcbb\" is \"abc\", which the length is 3.",
					"For \"bbbbb\" the longest substring is \"b\", with the length of 1.",
					"",
					"Solution:",
					"",
					"The idea is to keep the checked chars in a set, and take two pointer (i,j) to indexing the checking start/end points.",
					"If the current checking char is not in the set, add it in otherwise,",
					"",
					"check if (j-i) is the current maxLen. ",
					"Then remove those chars  from the set:  from current i position, remove the char till the 1st repeated char (same char as current j position)",
					"  ",
					"move i to the position after the repeated char (i++)",
					"",
					"After processing the input string, compare current maxLen and the last segment of the string (j-i or length -i)"

						);
				//@formatter:on


	}
}
