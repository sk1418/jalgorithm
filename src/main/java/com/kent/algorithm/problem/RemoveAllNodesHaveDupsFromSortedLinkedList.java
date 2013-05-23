package com.kent.algorithm.problem;

import com.kent.algorithm.Problem;
import com.kent.datastructure.ListNode;

/**
 * <p>
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * </p>
 * 
 * <pre>
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * 
 * </pre>
 * 
 * <b>Solution/Algorithm</b>
 * 
 * 
 * @author kent
 * 
 */
public class RemoveAllNodesHaveDupsFromSortedLinkedList extends Problem<ListNode, ListNode> {

	@Override
	public String getBigO() {
		return "Time: O(n); Space O(1)";
	}

	@Override
	public ListNode solve(ListNode data) {
		if (data == null || data.next == null) {
			return data;
		}

		ListNode head = null;
		ListNode result = null;
		ListNode tmp = null;
		boolean dup = false;
		while (data != null) {
			if (tmp == null) {
				tmp = data;
				data = data.next;
			} else if (data.val == tmp.val) {
				data = data.next;
				dup = true;
			} else {
				if (!dup) {
					if (head == null) {
						head = tmp;
						result = head;
					} else {
						head.next = tmp;
						head = head.next;
					}
				}
				tmp = data;
				dup = false;
				data = data.next;
			}

		}
		if (head == null) {
			head = !dup ? tmp : null;
			result = head;
		} else {
			head.next = !dup ? tmp : null;
		}

		return result;
	}
}
