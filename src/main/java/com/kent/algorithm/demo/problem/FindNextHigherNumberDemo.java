package com.kent.algorithm.demo.problem;

import static com.kent.util.AlgUtil.appendNewline;

import com.kent.algorithm.Problem;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.FindNextHigherNumber;

public class FindNextHigherNumberDemo extends AbstractDemo {
	private Long givenNumber;
	private Problem problem;

	@Override
	protected void warmingUp() {
		// warming up is not needed
	}

	@Override
	protected void prepareDemo() {
		givenNumber = 123456784987654321l;
		problem = new FindNextHigherNumber();
		problem.setPrintSteps(true);
	}

	@Override
	protected void specificDemo() {
		final Long result = (Long) problem.solve(givenNumber);
		print("next higher number of " + givenNumber + " is : " + result);
	}

	@Override
	protected void printDescription() {
		final StringBuffer sb = new StringBuffer();
		appendNewline(sb,
				"Given a number, find the next higher number which has the exact same set of digits as the original number. For example: given 38276 return 38627");
		appendNewline(sb, "");
		appendNewline(sb, "algorithm");
		appendNewline(sb, "Starting from the right, you find the first pair-of-digits such that the left-digit is smaller than the right-digit.");
		appendNewline(
				sb,
				"Let's refer to the left-digit by 'digit-x'. Find the smallest number larger than digit-x to the right of digit-x, and place it immediately left of digit-x.");
		appendNewline(sb,
				"Finally, sort the remaining digits in ascending order - since they were already in descending order, all you need to do is reverse them");
		appendNewline(sb, "(save for digit-x, which can be placed in the correct place in O(n)).");
		appendNewline(sb, " ");
		appendNewline(sb, " 23456784987654321");
		appendNewline(sb, " start with a number");
		appendNewline(sb, " ");
		appendNewline(sb, " 123456784 987654321");
		appendNewline(sb, "          ^the first place where the left-digit is less-than the right-digit is here.  Digit 'x' is 4");
		appendNewline(sb, " ");
		appendNewline(sb, " 123456784 987654321");
		appendNewline(sb, "               ^find the smallest digit larger than 4 to the right");
		appendNewline(sb, " ");
		appendNewline(sb, " 123456785 987644321");
		appendNewline(sb, "               ^ swap it with x");
		appendNewline(sb, " ");
		appendNewline(sb, " 123456785 123446789");
		appendNewline(sb, " 123456785123446789");
		appendNewline(sb,
				"          ^sort the digits to the right of 5.  Since all of them were already in descending order, all we need to do is reverse their order");
		print(sb.toString());
	}
}
