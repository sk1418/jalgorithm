package com.kent.algorithm.demo.problem;

import static com.kent.util.AlgUtil.*;

import com.google.common.base.Joiner;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.RemoveAllNodesHaveDupsFromSortedLinkedList;
import com.kent.datastructure.ListNode;

public class RemoveAllNodesHaveDupsFromSortedLinkedListDemo extends AbstractDemo {

	ListNode n1 = new ListNode(1);
	ListNode n2 = new ListNode(1);
	ListNode n3 = new ListNode(1);
	ListNode n4 = new ListNode(2);
	ListNode n5 = new ListNode(3);
	ListNode n6 = new ListNode(3);
	ListNode n7 = new ListNode(4);
	ListNode n8 = new ListNode(5);

	private RemoveAllNodesHaveDupsFromSortedLinkedList problem;

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

		problem = new RemoveAllNodesHaveDupsFromSortedLinkedList();
		problem.setPrintSteps(true);
	}

	@Override
	protected void specificDemo() {
		print(String.format("Complexity: %s\n", problem.getBigO()));
		doJob(n1);
	}

	private void doJob(final ListNode input) {

		print("Given LinkedList :" + input.toString());
		stopwatch.start();
		final ListNode newHead = problem.solve(input);
		stopwatch.stop();
		print("Result           :" + newHead.toString());
		print(stopwatch.readAsString());
		print(repeatString("=", 50));
		stopwatch.reset();
	}

	@Override
	protected void printDescription() {
		//@formatter:off
		final String d =Joiner.on("\n").join(
				 " Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.",
				 " ",
				 " For example,",
				 " Given 1->2->3->3->4->4->5, return 1->2->5.",
				 " Given 1->1->1->2->3, return 2->3.",
				 " ",
				 " ",
				 " Solution/Algorithm",
				 " ",
				 " ",
				 " Assume the given list with head node \"data\"",
				 " - if data==null or data.next == null, data is the answer",
				 " - create two pointer, one named later, one name checker, and a dup boolean flag",
				 " - create one head node with dummy value. result pointer points to head. the result.next would be answer",
				 " - later->data; checker->data.next",
				 " - if checker!=null iterate following steps:",
				 "   > later.val == checker.val? checker goes to next node, set dup flag=true, next iteration",
				 "   > if later.val!=checker.val",
				 "         if dup==false? head->later, head->head.next",
				 "         reset dup flag later->checker, checker->checker.next; next iteration",
				 "   > after last iteration, we need to check if the current later should be in answer:",
				 "     head.next = !dup ? later : null;",
				 "   > return result.next"
		);
		//@formatter:on

		print(d);
	}
}
