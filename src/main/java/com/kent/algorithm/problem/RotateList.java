package com.kent.algorithm.problem;

import java.util.Map;

import com.kent.algorithm.Problem;
import com.kent.datastructure.ListNode;

/**
 * {1,2,3,4,5}, 9 {2,3,4,5,1} {2,3,4,5,1}
 * 
 * {1,2,3,4,5}, 10 {1,2,3,4,5} {1,2,3,4,5}
 * 
 * @author kent
 * 
 */
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
			head = node;
			node = node.next;
		}
		head = node.next;
		node.next = null;
		return head;

	}

}
