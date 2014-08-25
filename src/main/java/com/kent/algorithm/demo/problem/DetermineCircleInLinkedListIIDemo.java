package com.kent.algorithm.demo.problem;

import java.util.List;

import com.google.common.base.Joiner;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.DetermineCircleInLinkedList;
import com.kent.algorithm.problem.DetermineCircleInLinkedListII;
import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoType;
import com.kent.datastructure.ListNode;

import static com.kent.util.AlgUtil.repeatString;

@Demo(type = DemoType.LinkedList, name="Find Circle Begin Node")
public class DetermineCircleInLinkedListIIDemo extends AbstractDemo {

	ListNode n1 = new ListNode(1);
	ListNode n2 = new ListNode(2);
	ListNode n3 = new ListNode(3);
	ListNode n4 = new ListNode(4);
	ListNode n5 = new ListNode(5);
	ListNode n6 = new ListNode(6);
	ListNode n7 = new ListNode(7);
	ListNode n8 = new ListNode(8);

	private final List<ListNode> input = null;
	private DetermineCircleInLinkedListII problem;

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

		problem = new DetermineCircleInLinkedListII();
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
		print("The cycle starts on: " + problem.solve(input).val);
		stopwatch.stop();
		print(stopwatch.readAsString());
		print(repeatString("=", 50));
		stopwatch.reset();
	}

	@Override
	protected String demoDescription() {
		//@formatter:off
		return Joiner.on("\n").join(
				"From http://oj.leetcode.com/problems/linked-list-cycle-ii/",
				"",
				"Given a linked list, return the node where the cycle begins. If there is no cycle, return null.",
				"",
				"Follow up:",
				"Can you solve it without using extra space?",
				"",
				" Algorithm/Solution ",
				"",
				"    still two nodes, one 2x faster than the slow one. See {@link DetermineCircleInLinkedList}",
				"    head is the start node of the list",
				"    length between head and the cycle starting is x",
				"    length of the cycle is: y",
				"    the fast and slow meet at node: m",
				"  ",
				"  ",
				"When the both meet, the length ran by fast is 2x of the length of the slow one:",
				"   ",
				"       x + m + ky = 2*(x + m + ty)",
				"       => ky = 2ty + x + m",
				"       => (x+m) % y = 0",
				"   ",
				"",
				"It means that from the length between m and x is x, that is, from m run x step with speed 1 will reach the x node. "
				);
		//@formatter:on

	}

}
