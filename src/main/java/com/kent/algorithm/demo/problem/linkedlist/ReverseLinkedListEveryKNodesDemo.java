package com.kent.algorithm.demo.problem.linkedlist;

import static com.kent.util.AlgUtil.*;

import java.util.Map;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.linkedlist.ReverseLinkedListEveryKNodes;
import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoType;
import com.kent.datastructure.ListNode;

@Demo(type = DemoType.LinkedList, name="Reverse every K nodes in List")
public class ReverseLinkedListEveryKNodesDemo extends AbstractDemo {

	ListNode n1 = new ListNode(1);
	ListNode n2 = new ListNode(2);
	ListNode n3 = new ListNode(3);
	ListNode n4 = new ListNode(4);
	ListNode n5 = new ListNode(5);
	ListNode n6 = new ListNode(6);
	ListNode n7 = new ListNode(7);
	ListNode n8 = new ListNode(8);

	private Map<String, Object> input = null;
	private ReverseLinkedListEveryKNodes problem;

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

		input = Maps.newHashMap();
		problem = problem == null ? new ReverseLinkedListEveryKNodes() : problem;
		problem.setPrintSteps(true);
	}

	@Override
	protected void specificDemo() {
		print(String.format("Complexity: %s\n", problem.getBigO()));
		input.put("head", n1);
		input.put("k", 2);
		doJob(input);

		prepareDemo();
		input.put("head", n1);
		input.put("k", 3);
		doJob(input);
	}

	private void doJob(final Map<String, Object> input) {
		final ListNode node = (ListNode) input.get("head");
		final int k = (Integer) input.get("k");

		print("Input LinkedList :" + node.toString());
		print("               K :" + k);
		stopwatch.start();
		final ListNode newHead = problem.solve(input);
		stopwatch.stop();
		print("After reversing  :" + newHead.toString());
		print(stopwatch.readAsString());
		print(repeatString("=", 50));
		stopwatch.reset();
	}

	@Override
	protected String demoDescription() {
		//@formatter:off
		return Joiner.on("\n").join(
				" Given a linked list, reverse the nodes of a linked list k at a time and return its modified list. If the number of nodes is not a multiple of k",
				 " then left-out nodes in the end should remain as it is. You may not alter the values in the nodes, only nodes itself may be changed.",
				 " ",
				 " Only constant memory space: O(1) is allowed.",
				 " ",
				 " For example,",
				 " ",
				 " ",
				 " Given this linked list: 1->2->3->4->5",
				 " ",
				 " For k = 2, you should return: 2->1->4->3->5",
				 " ",
				 " For k = 3, you should return: 3->2->1->4->5",
				 " ",
				 " Solution/Algorithm",
				 " ",
				 "     newHead would be the result node to be returned ",
				 "    0) if the given node(head) is null or head.next is null, return head",
				 "    1) get length of the whole list \"l\"",
				 "    2) if k>l return head",
				 "    3) iterate following process l/k times:",
				 "    4)",
				 "      -reverse the list from head till k-1 nodes after head (@see ReverseLinkedList)",
				 "      - take the reversed first and last node",
				 "      - if newHead is null, set newHead = first (this will be done in first iteration)",
				 "      - tail is the \"last\" of pervious iteration. init value null",
				 "          if (tail != null) {",
				 " 				tail.next = first;",
				 " 			}",
				 " 			tail = last;",
				 "      - set head = tail.next"
			
	
		);
		//@formatter:on

	}
}
