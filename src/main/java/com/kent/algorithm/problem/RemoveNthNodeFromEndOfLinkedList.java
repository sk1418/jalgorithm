package com.kent.algorithm.problem;

import java.util.Map;

import com.kent.algorithm.Problem;
import com.kent.datastructure.ListNode;

/**
 * 
 * <p>
 * Given linked list:
 * 
 * <pre>
 *   1->2->3->4->5, and n = 2.
 * </pre>
 * 
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * 
 * <pre>
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * </pre>
 * 
 * </p>
 * 
 * 
 * <b> Algorithm/Solution </b>
 * <p>
 * use two pointers,fast pointer forward n steps first
 * </p>
 * 
 * @author kent
 * 
 */
public class RemoveNthNodeFromEndOfLinkedList extends Problem<Map<String, Object>, ListNode> {

	@Override
	public String getBigO() {
		return "O(n)";
	}

	@Override
	public ListNode solve(final Map<String, Object> data) {
		final ListNode head = (ListNode) data.get("head");
		int n = (Integer) data.get("n");

		ListNode slow = head;
		ListNode fast = head;

		while (fast.next != null) {
			fast = fast.next;
			if (n-- <= 0) {
				slow = slow.next;
				// only for demo
				if (printSteps()) {
					// AlgUtil.println("Slow pointer : " = )
				}
			}
		}

		if (slow == head) {
			return head.next;
		}
		slow.next = slow.next.next;
		return head;

	}

}
