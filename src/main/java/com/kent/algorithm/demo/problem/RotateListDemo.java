package com.kent.algorithm.demo.problem;

import java.util.List;
import java.util.Map;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.RotateList;
import com.kent.datastructure.ListNode;

public class RotateListDemo extends AbstractDemo {

	ListNode n1 = new ListNode(1);
	ListNode n2 = new ListNode(2);
	ListNode n3 = new ListNode(3);
	ListNode n4 = new ListNode(4);
	ListNode n5 = new ListNode(5);

	private final List<ListNode> input = null;
	private RotateList problem;

	@Override
	protected void warmingUp() { // warming up is not required
	}

	@Override
	protected void prepareDemo() {
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		problem = problem == null ? new RotateList() : problem;
	}

	@Override
	protected void specificDemo() {
		final Map<String, Object> input = Maps.newHashMap();
		input.put("head", n1);
		input.put("times", 9);
		print(String.format("Complexity: %s\n", problem.getBigO()));
		doJob(input);
		print("========");
		// reset the input ListNode
		prepareDemo();

		input.put("head", n1);
		input.put("times", 10);
		doJob(input);
	}

	private void doJob(final Map<String, Object> input) {

		print("Input LinkedList :" + input.get("head").toString());
		print("Rotate " + input.get("times") + " times to the right:");
		final ListNode newHead = problem.solve(input);
		print("Rotated LinkedList :" + newHead.toString());
	}

	@Override
	protected void printDescription() {
		//@formatter:off
		final String d =Joiner.on("\n").join(
				" Given a list, rotate the list to the right by k places, where k is non-negative.",
				" single linkedlist:",
				" ",
				" ",
				" public class ListNode {",
				"     int val;",
				"     ListNode next;",
				"     ListNode(int x) {",
				"         val = x;",
				"         next = null;",
				"     }",
				" ",
				" ",
				" For example:",
				" ",
				" ",
				" ",
				" Given 1->2->3->4->5->NULL and k = 2,",
				" return 4->5->1->2->3->NULL.",
				" ",
				" also ",
				" ",
				" {1,2,3,4,5}, 9 to {2,3,4,5,1}",
				" {1,2,3,4,5}, 10  to {1,2,3,4,5}",
				" ",
				" ",
				" ",
				"  first make the linkedlist a circle, then calculate the new tail and head. Find the xth node from head. (x=length - k % length -",
				" 1) x-node is new tail and the x.next is new head."
		);
		//@formatter:on

		print(d);
	}

}
