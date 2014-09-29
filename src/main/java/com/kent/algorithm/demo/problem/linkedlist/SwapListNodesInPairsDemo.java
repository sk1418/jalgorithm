package com.kent.algorithm.demo.problem.linkedlist;

import static com.kent.util.AlgUtil.*;

import java.util.List;

import com.google.common.base.Joiner;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.linkedlist.SwapListNodesInPairs;
import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoType;
import com.kent.datastructure.ListNode;

@Demo(type = DemoType.LinkedList, name="Swap List Nodes in pair")
public class SwapListNodesInPairsDemo extends AbstractDemo {

	ListNode n1 = new ListNode(1);
	ListNode n2 = new ListNode(2);
	ListNode n3 = new ListNode(3);
	ListNode n4 = new ListNode(4);
	ListNode n5 = new ListNode(5);

	ListNode m1 = new ListNode(10);
	ListNode m2 = new ListNode(20);
	ListNode m3 = new ListNode(30);
	ListNode m4 = new ListNode(40);
	ListNode m5 = new ListNode(50);
	ListNode m6 = new ListNode(60);

	private final List<ListNode> input = null;
	private SwapListNodesInPairs problem;

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

		m1.next = m2;
		m2.next = m3;
		m3.next = m4;
		m4.next = m5;
		m5.next = m6;
		m6.next = null;

		problem = problem == null ? new SwapListNodesInPairs() : problem;
		problem.setPrintSteps(true);
	}

	@Override
	protected void specificDemo() {
		print(String.format("Complexity: %s\n", problem.getBigO()));
		doJob(n1);
		doJob(m1);
	}

	private void doJob(final ListNode input) {

		print("Input LinkedList :" + input.toString());
		stopwatch.start();
		final ListNode newHead = problem.solve(input);
		stopwatch.stop();
		print("After swapping   :" + newHead.toString());
		print(stopwatch.readAsString());
		print(repeatString("=", 50));
		stopwatch.reset();
	}

	@Override
	protected String demoDescription() {
		//@formatter:off
		return Joiner.on("\n").join(
				 "Given a linked list, swap every two adjacent nodes and return its head.",
				 " ",
				 " For example",
				 " ",
				 " [1->2->3->4] to [2->1->4->3]  ",
				 " ",
				 " Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.",
				 " ",
				 " Solution/Algorithm",
				 " ",
				 "  current processing node: curr= b",
				 " ",
				 "    ....-> a -> b -> c -> d ...",
				 " ",
				 "    ....-> a    b -> c -> d ...",
				 "           |         ^",
				 "           +---------|",
				 " ",
				 "                +---------+",
				 "                |         v",
				 "    ....-> a    b    c -> d ...",
				 "           |         ^",
				 "           +---------|",
				 " ",
				 "                +---------+",
				 "                |         v",
				 "    ....-> a    b <- c    d ...",
				 "           |         ^",
				 "           +---------|",
				 "    ",
				 "    ....-> a -> c -> b -> d ...       ",
				 " ",
				 "    curr = b.next (d)"
		);
		//@formatter:on

	}

}
