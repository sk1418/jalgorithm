package com.kent.algorithm.demo.problem;

import com.google.common.base.Joiner;
import com.kent.algorithm.Problem;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.FindNextHigherNumber;
import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoType;

@Demo(type = DemoType.Problems, name="Find Next Higher Number")
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

		//@formatter:off
			final String d =Joiner.on("\n").join(
						
					"Given a number, find the next higher number which has the exact same set of digits as the original number. For example: given 38276 return 38627",
					"",
					"algorithm",
					"Starting from the right, you find the first pair-of-digits such that the left-digit is smaller than the right-digit.",
					 "Let's refer to the left-digit by 'digit-x'. Find the smallest number larger than digit-x to the right of digit-x, and place it immediately left of digit-x.",
					"Finally, sort the remaining digits in ascending order - since they were already in descending order, all you need to do is reverse them",
					"(save for digit-x, which can be placed in the correct place in O(n)).",
					" ",
					" 23456784987654321",
					" start with a number",
					" ",
					" 123456784 987654321",
					"          ^the first place where the left-digit is less-than the right-digit is here.  Digit 'x' is 4",
					" ",
					" 123456784 987654321",
					"               ^find the smallest digit larger than 4 to the right",
					" ",
					" 123456785 987644321",
					"               ^ swap it with x",
					" ",
					" 123456785 123446789",
					" 123456785123446789",
					"          ^sort the digits to the right of 5.  Since all of them were already in descending order, all we need to do is reverse their order"
						);
				//@formatter:on

		print(d);

	}
}
