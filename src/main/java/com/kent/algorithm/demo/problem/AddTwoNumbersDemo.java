package com.kent.algorithm.demo.problem;

import static com.kent.util.AlgUtil.*;

import java.util.List;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.AddTwoNumbers;
import com.kent.datastructure.ListNode;

public class AddTwoNumbersDemo extends AbstractDemo {

	ListNode n1 = new ListNode(7);
	ListNode n2 = new ListNode(8);
	ListNode n3 = new ListNode(9);

	ListNode m1 = new ListNode(9);
	ListNode m2 = new ListNode(8);

	private List<ListNode> input = null;
	private AddTwoNumbers problem;

	@Override
	protected void warmingUp() { // warming up is not required
	}

	@Override
	protected void prepareDemo() {
		n1.next = n2;
		n2.next = n3;
		m1.next = m2;
		problem = new AddTwoNumbers();
		input = ImmutableList.of(n1, m1);
	}

	@Override
	protected void specificDemo() {
		print(String.format("Complexity: %s\n", problem.getBigO()));
		print("LinkedList 1: " + input.get(0).toString());
		print("LinkedList 2: " + input.get(1).toString());
		stopwatch.start();
		print("SUM         : " + problem.solve(input).toString());
		stopwatch.stop();
		print(stopwatch.readAsString());
		print(repeatString("=", 50));
		stopwatch.reset();
	}

	@Override
	protected void printDescription() {
		//@formatter:off
		final String d =Joiner.on("\n").join(
				"  You are given two linked lists (ListNode Type) representing two non-negative numbers. The digits are stored in reverse order and each of their",
				"  nodes contain a single digit. Add the two numbers and return it as a linked list.",
				"  ",
				"  Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)",
				"  Output: 7 -> 0 -> 8",
				"  ",
				"  ListNode type:",
				"  ",
				"  public class ListNode {",
				"  	int val;",
				"  	ListNode next;",
				"  ",
				"  	ListNode(final int x) {",
				"  		val = x;",
				"  		next = null;",
				"  	}",
				"  }"

		);
		//@formatter:on

		print(d);
	}

}
