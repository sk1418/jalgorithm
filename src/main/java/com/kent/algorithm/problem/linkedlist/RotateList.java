package com.kent.algorithm.problem.linkedlist;

import java.util.Map;

import com.kent.algorithm.Problem;
import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoType;
import com.kent.datastructure.ListNode;

/**
 * From http://oj.leetcode.com/problems/rotate-list/
 * <br/>
 * Given a list, rotate the list to the right by k places, where k is non-negative.</br>
 * single linkedlist:
 * 
 * <pre>
 * public class ListNode {
 * 	int val;
 * 	ListNode next;
 * 
 * 	ListNode(int x) {
 * 		val = x;
 * 		next = null;
 * 	}
 * }
 * </pre>
 * 
 * <p>
 * For example:
 * </p>
 * 
 * <pre>
 * {@code
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * 
 * also 
 * 
 * {1,2,3,4,5}, 9 to {2,3,4,5,1}
 * {1,2,3,4,5}, 10  to {1,2,3,4,5}
 * }
 * </pre>
 * 
 * <p>
 * <b> Algorithm </b> first make the linkedlist a circle, then calculate the new tail and head. Find the xth node from head. (x=length - k % length -
 * 1) x-node is new tail and the x.next is new head.
 * </p>
 * 
 * @author kent
 * 
 */
@Demo(type = DemoType.LinkedList, name="Rotate List")
public class RotateList extends Problem<Map<String, Object>, ListNode> {

	@Override
	public String getBigO() {
		return "O(n)";
	}

	@Override
	public ListNode solve(final Map<String, Object> data) {
		ListNode head = (ListNode) data.get("head");
		final int n = (Integer) data.get("times");

		if (head == null || n == 0) {
			return head;
		}
		ListNode node = head;
		int c = 1; // length of the
		while (node.next != null) {
			node = node.next;
			c++;
		}
		node.next = head;
		node = head;

		for (int i = 1; i <= c - n % c - 1; i++) {
			node = node.next;
		}
		head = node.next;
		node.next = null;
		return head;

	}

}
