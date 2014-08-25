package com.kent.algorithm.demo.problem;

import java.util.List;

import com.google.common.base.Joiner;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.ReverseLinkedList;
import com.kent.algorithm.problem.SortList;
import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoType;
import com.kent.datastructure.ListNode;

import static com.kent.util.AlgUtil.repeatString;

@Demo(type = DemoType.LinkedList, name="Sort List")
public class SortListDemo extends AbstractDemo {

		final ListNode n1 = new ListNode(8);
		final ListNode n2 = new ListNode(7);
		final ListNode n3 = new ListNode(1);
		final ListNode n4 = new ListNode(4);
		final ListNode n5 = new ListNode(5);
		final ListNode n6 = new ListNode(2);
		final ListNode n7 = new ListNode(3);
		final ListNode n8 = new ListNode(6);


	private  ListNode input = null;
	private SortList problem;

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
		input = n1;

		problem = new SortList();
		problem.setPrintSteps(true);
	}

	@Override
	protected void specificDemo() {
		print(String.format("Complexity: %s\n", problem.getBigO()));
		doJob(n1);
	}

	private void doJob(final ListNode input) {

		print("Input LinkedList :" + input);
		stopwatch.start();
		final ListNode newHead = problem.solve(input);
		stopwatch.stop();
		print("After Sorting  :" + newHead);
		print(stopwatch.readAsString());
		print(repeatString("=", 50));
		stopwatch.reset();
	}

	@Override
	protected String demoDescription() {
		//@formatter:off
		return Joiner.on("\n").join(
				 " Sort a Linked list",
				 " ",
				 " Solution:",
				 " Merge sort with List could do in-place merge!",
				 " ",
				 "     - finding the mid node by two pointer, one slow one fast (2x slow)",
				 "     - then cut the original list into two parts: head->...->mid->null and (mid.next)->..->last->null",
				 "     - recursively mergesort and merge each part."
		);
		//@formatter:on

	}

}
