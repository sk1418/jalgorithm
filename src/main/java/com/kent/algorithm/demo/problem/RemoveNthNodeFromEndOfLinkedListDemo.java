package com.kent.algorithm.demo.problem;

import static com.kent.util.AlgUtil.*;

import java.util.List;
import java.util.Map;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.RemoveNthNodeFromEndOfLinkedList;
import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoType;
import com.kent.datastructure.ListNode;

@Demo(type = DemoType.LinkedList, name="Remove N-th Node From End")
public class RemoveNthNodeFromEndOfLinkedListDemo extends AbstractDemo {

	ListNode n1 = new ListNode(1);
	ListNode n2 = new ListNode(2);
	ListNode n3 = new ListNode(3);
	ListNode n4 = new ListNode(4);
	ListNode n5 = new ListNode(5);

	private final List<ListNode> input = null;
	private RemoveNthNodeFromEndOfLinkedList problem;

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
		problem = problem == null ? new RemoveNthNodeFromEndOfLinkedList() : problem;
		problem.setPrintSteps(true);
	}

	@Override
	protected void specificDemo() {
		final Map<String, Object> input = Maps.newHashMap();
		input.put("head", n1);
		input.put("n", 2);
		print(String.format("Complexity: %s\n", problem.getBigO()));
		doJob(input);
		// reset the input ListNode
		prepareDemo();

		input.put("head", n1);
		input.put("n", 5);
		doJob(input);
	}

	private void doJob(final Map<String, Object> input) {

		print("Input LinkedList :" + input.get("head").toString());
		print("Remove the " + input.get("n") + "th node from end:");
		stopwatch.start();
		final ListNode newHead = problem.solve(input);
		stopwatch.stop();
		print("Rotated LinkedList :" + newHead.toString());
		print(stopwatch.readAsString());
		print(repeatString("=", 50));
		stopwatch.reset();
	}

	@Override
	protected void printDescription() {
		//@formatter:off
		final String d =Joiner.on("\n").join(
				 " Given linked list:",
				 " ",
				 "   1->2->3->4->5, and n = 2.",
				 " ",
				 " After removing the second node from the end, the linked list becomes 1->2->3->5.",
				 " ",
				 " Note:",
				 " - Given n will always be valid.",
				 " - Try to do this in one pass.",
				 " ",
				 " ",
				 "  Algorithm/Solution ",
				 " ",
				 " use two pointers,fast pointer forward n steps first"
		);
		//@formatter:on

		print(d);
	}

}
