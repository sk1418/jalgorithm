package com.kent.algorithm.demo.problem;

import java.util.Arrays;

import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.SortingStringsWithTotalNChars;
import com.kent.util.AlgUtil;

public class SortingStringsWithNCharsDemo extends AbstractDemo {
	/** The small array. */
	private String[] smallArray;

	/** The problem. */
	private SortingStringsWithTotalNChars problem;

	@Override
	protected void prepareDemo() {
		smallArray = new String[] { "The", "most", "common", "variant", "of", "bucket", "sort", "operates", "on", "a", "list", "of", "n", "numeric",
				"inputs", "between", "zero", "and", "some", "maximum", "value", "M", "and", "divides", "the", "value", "range", "into", "n",
				"buckets", "each", "of", "size", "M/n" };
		problem = new SortingStringsWithTotalNChars();
		problem.setPrintSteps(true);

	}

	@Override
	protected void specificDemo() {

		print("Time complexity:" + problem.getBigO());
		doJob(smallArray);
	}

	@Override
	protected void warmingUp() {
		// do not need warmingUp

	}

	/**
	 * Do job.
	 * 
	 * @param a
	 *            the a
	 */
	private void doJob(final String[] a) {
		print("Array: " + Arrays.toString(a));
		print(AlgUtil.repeatString("=", 50));

		stopwatch.start();
		final String[] result = problem.solve(a);
		stopwatch.stop();
		print("sorted:");
		for (final String s : result) {
			print(s);
		}
		print(AlgUtil.repeatString("=", 50));
		print(stopwatch.readAsString());
		stopwatch.reset();
	}

	@Override
	protected void printDescription() {
		final StringBuffer sb = new StringBuffer();
		AlgUtil.appendNewline(sb, "You are given an array of strings, where different strings may have different");
		AlgUtil.appendNewline(sb, "numbers of characters, but the total number of characters over all the");
		AlgUtil.appendNewline(sb, "strings is n. Show how to sort the strings in O(n) time. (Note that the");
		AlgUtil.appendNewline(sb, "desired order here is the standard alphabetical order; for example, a < ab < b.)");
		AlgUtil.appendNewline(sb, "");
		AlgUtil.appendNewline(sb, "");
		AlgUtil.appendNewline(sb, "To solve the problem in O(n) time, we use the property that, if the first");
		AlgUtil.appendNewline(sb, "letter of string x is lexicographically less that the first letter of string");
		AlgUtil.appendNewline(sb, "y, then x is lexicographically less than y, regardless of the lengths of the");
		AlgUtil.appendNewline(sb, "two strings. We take advantage of this property by sorting the strings on the");
		AlgUtil.appendNewline(sb, "first letter, using counting sort. We take an empty string as a special case");
		AlgUtil.appendNewline(sb, "and put it first. We gather together all strings with the same first letter");
		AlgUtil.appendNewline(sb, "as a group. Then we recurse, within each group, based on each string with the");
		AlgUtil.appendNewline(sb, "first letter removed.");

		print(sb.toString());

	}
}
