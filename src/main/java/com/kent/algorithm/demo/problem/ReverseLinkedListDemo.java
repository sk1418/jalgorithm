package com.kent.algorithm.demo.problem;

import static com.kent.util.AlgUtil.*;

import java.util.List;

import com.google.common.base.Joiner;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.ReverseLinkedList;
import com.kent.datastructure.ListNode;

public class ReverseLinkedListDemo extends AbstractDemo {

	ListNode n1 = new ListNode(1);
	ListNode n2 = new ListNode(2);
	ListNode n3 = new ListNode(3);
	ListNode n4 = new ListNode(4);
	ListNode n5 = new ListNode(5);
	ListNode n6 = new ListNode(6);
	ListNode n7 = new ListNode(7);
	ListNode n8 = new ListNode(8);

	private final List<ListNode> input = null;
	private ReverseLinkedList problem;

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
		n8.next = null;

		problem = new ReverseLinkedList();
	}

	@Override
	protected void specificDemo() {
		print(String.format("Complexity: %s\n", problem.getBigO()));
		doJob(n1);
	}

	private void doJob(final ListNode input) {

		print("Input LinkedList :" + input.toString());
		stopwatch.start();
		final ListNode newHead = problem.solve(input);
		stopwatch.stop();
		print("After reversing  :" + newHead.toString());
		print(stopwatch.readAsString());
		print(repeatString("=", 50));
		stopwatch.reset();
	}

	@Override
	protected void printDescription() {
		//@formatter:off
		final String d =Joiner.on("\n").join(
				 " Reverse a singly linkedlist.",
				 " ",
				 " For example",
				 " ",
				 " [ 1 -> 2 -> 3 -> 4 -> 5 ] to [ 5 -> 4 -> 3 -> 2 -> 1 ]  ",
				 " ",
				 " Your algorithm should use only constant space O(1). You may not modify the values in the list, only nodes itself can be changed.",
				 " ",
				 " ",
				 " Algorithm/Solution: ",
				 "    taking 1 as head",
				 "    taking 1 as current, 1 is always the current",
				 "    saving 1.next.next (3) to nn",
				 " 1) current.next.next = head",
				 "    head = current.next (2)",
				 " 2) current.next = nn (1->3)",
				 " ",
				 " Iterate the steps above, till end",
				 " ",
				 " ",
				 "   +-(1)+ ",
				 "   v    |",
				 "   1    2    3 -> 4 -> 5 -> [Null]",
				 "   |         ^",
				 "   +---(2)---+",
				 " ",
				 " ",
				 "   +---(1)---+",
				 "   v         |",
				 "   2 -> 1    3    4 -> 5 -> [Null]",
				 "        |         ^",
				 "        +---(2)---+",
				 " ",
				 " ",
				 "   +-----(1)------+",
				 "   v              |",
				 "   3 -> 2 -> 1    4    5 -> [Null]",
				 "             |         ^",
				 "             +---(2)---+",
				 " ",
				 " ",
				 "   +-------(1)---------+",
				 "   v                   |",
				 "   4 -> 3 -> 2 -> 1    5    [Null]",
				 "                  |           ^",
				 "                  +----(2)----+",
				 " ",
				 " ",
				 "   5 -> 4 -> 3 -> 2 -> 1 -> [Null]"
		);
		//@formatter:on

		print(d);
	}

}
