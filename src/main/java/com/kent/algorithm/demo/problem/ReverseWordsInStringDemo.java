package com.kent.algorithm.demo.problem;

import java.util.Arrays;

import com.google.common.base.Joiner;
import com.kent.algorithm.Problem;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.PlusOne;
import com.kent.algorithm.problem.ReverseWordsInString;
import com.kent.util.AlgUtil;

public class ReverseWordsInStringDemo extends AbstractDemo {

	/** The problem. */
	private Problem<String, String> problem;
	String input = "    this     is an     example    ";

	@Override
	protected void prepareDemo() {
		problem = new ReverseWordsInString();
		problem.setPrintSteps(true);
	}

	@Override
	protected void specificDemo() {

		print(problem.getBigO());
		doJob(input);
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
	private void doJob(final String a) {

		printf("Input String: \"%s\"\n" , a );
		print(AlgUtil.repeatString("=", 50));

		stopwatch.start();
		final String result = problem.solve(a);
		stopwatch.stop();
		printf("Result: \"%s\"\n", result);
		print(AlgUtil.repeatString("=", 50));
		print(stopwatch.readAsString());
		stopwatch.reset();
	}

	@Override
	protected void printDescription() {
	//@formatter:off
		final String d = Joiner.on("\n").join(
			" from leetcode:https://oj.leetcode.com/problems/reverse-words-in-a-string/",
			"",
			" Given an input string, reverse the string word by word.",
			"",
			" For example,",
			" ",
			" Given s = \"the sky is blue\",",
			" return \"blue is sky the\".",
			"",
			" Clarification:",
			" What constitutes a word?",
			" - A sequence of non-space characters constitutes a word.",
			"",
			" - Could the input string contain leading or trailing spaces?",
			" > Yes. However, your reversed string should not contain leading or trailing spaces.",
			" ",
			" - How about multiple spaces between two words?",
			" > Reduce them to a single space in the reversed string.",
			"",
			" Solution",
			"    - trim and split the string",
			"    - push each element into a stack",
			"    - pop word from stack and concatenate spaces"

		);
		//@formatter:on

		print(d);

	}
}
