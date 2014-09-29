package com.kent.algorithm.demo.problem;

import com.google.common.base.Joiner;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.ValidPalindrome;
import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoType;

@Demo(type = DemoType.Problems, name="Check Palindrome String")
public class ValidPalindromeDemo extends AbstractDemo {

	private ValidPalindrome problem;
	private String s1;
	private String s2;


	@Override
	protected void warmingUp() { // warming up is not required
	}

	@Override
	protected void prepareDemo() {
		s1 = "A man, a plan, a canal: Panama";
		s2 = "race a car";
		problem = new ValidPalindrome();
	}

	@Override
	protected void specificDemo() {
		print(String.format("Complexity: %s\n", problem.getBigO()));
		stopwatch.start();
		print("String1: " + s1);
		print("String 1 is palindrome: " + problem.solve(s1));
		print("String2: " + s2);
		print("String 2 is palindrome: " + problem.solve(s2));
		stopwatch.stop();
		print(stopwatch.readAsString());

		printLine("=", 50);
		stopwatch.reset();
	}

	@Override
	protected String demoDescription() {
		//@formatter:off
		return Joiner.on("\n").join(

			" From: https://oj.leetcode.com/problems/valid-palindrome/",
			" ",
			" Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.",
			" ",
			" For example,",
			" ",
			" \"A man, a plan, a canal: Panama\" is a palindrome.",
			" \"race a car\" is not a palindrome.",
			" ",
			" Note:",
			" Have you consider that the string might be empty? This is a good question to ask during an interview.",
			"",
			" For the purpose of this problem, we define empty string as valid palindrome.",
			""
		);
		//@formatter:on

	}

}
