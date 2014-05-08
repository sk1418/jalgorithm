package com.kent.algorithm.demo.problem;

import java.util.List;

import com.google.common.base.Joiner;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.DetermineCircleInLinkedList;
import com.kent.algorithm.problem.ReverseLinkedList;
import com.kent.datastructure.ListNode;

import static com.kent.util.AlgUtil.repeatString;

public class DetermineCircleInLinkedListDemo extends AbstractDemo {

	ListNode n1 = new ListNode(1);
	ListNode n2 = new ListNode(2);
	ListNode n3 = new ListNode(3);
	ListNode n4 = new ListNode(4);
	ListNode n5 = new ListNode(5);
	ListNode n6 = new ListNode(6);
	ListNode n7 = new ListNode(7);
	ListNode n8 = new ListNode(8);

	private final List<ListNode> input = null;
	private DetermineCircleInLinkedList problem;

	@Override
	protected void warmingUp() { // warming up is not required
	}

	@Override
	protected void prepareDemo() {
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n3;

		problem = new DetermineCircleInLinkedList();
		problem.setPrintSteps(true);
	}

	@Override
	protected void specificDemo() {
		print(String.format("Complexity: %s\n", problem.getBigO()));
		doJob(n1);
	}

	private void doJob(final ListNode input) {

		print("Input LinkedList :1-> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 3");
		stopwatch.start();
		print("Does the list has circle? " + problem.solve(input));
		stopwatch.stop();
		print(stopwatch.readAsString());
		print(repeatString("=", 50));
		stopwatch.reset();
	}

	@Override
	protected void printDescription() {
		//@formatter:off
		final String d =Joiner.on("\n").join(
				"From http://oj.leetcode.com/problems/linked-list-cycle/",
				"",
				"Given a linked list, determine if it has a cycle in it.",
				"Follow up:",
				"Can you solve it without using extra space?",
				"",
				"Algorithm/Solution ",
				"",
				"use two pointers,fast pointer moves 2 nodes once, see if two pointers will meet.",
				""

		);
		//@formatter:on

		print(d);
	}

}
