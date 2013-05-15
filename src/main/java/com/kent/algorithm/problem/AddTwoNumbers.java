package com.kent.algorithm.problem;

import java.util.List;

import com.kent.algorithm.Problem;
import com.kent.datastructure.ListNode;

/**
 * <p>
 * You are given two linked lists (ListNode Type) representing two non-negative numbers. The digits are stored in reverse order and each of their
 * nodes contain a single digit. Add the two numbers and return it as a linked list.
 * </p>
 * 
 * <pre>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * </pre>
 * 
 * <pre>
 * ListNode type:
 * 
 * public class ListNode {
 * 	int val;
 * 	ListNode next;
 * 
 * 	ListNode(final int x) {
 * 		val = x;
 * 		next = null;
 * 	}
 * }
 * </pre>
 * 
 * @author kent
 * 
 */
public class AddTwoNumbers extends Problem<List<ListNode>, ListNode> {

	@Override
	public String getBigO() {
		return "O(n)";
	}

	@Override
	public ListNode solve(final List<ListNode> data) {
		// assume the given lists are not null
		ListNode l1 = data.get(0);
		ListNode l2 = data.get(1);
		ListNode result = null;
		ListNode tmpNode = null;
		ListNode tmpTail = null;

		int carry = 0;

		while (l1 != null || l2 != null || carry > 0) {
			final int v = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
			tmpTail = new ListNode(v > 9 ? v - 10 : v);
			if (result == null) {
				result = tmpTail;
				tmpNode = tmpTail;
			} else {
				tmpNode.next = tmpTail;
				tmpNode = tmpNode.next;
			}
			l1 = l1 == null ? l1 : l1.next;
			l2 = l2 == null ? l2 : l2.next;
			carry = v >= 10 ? 1 : 0;
		}

		return result;
	}

}
