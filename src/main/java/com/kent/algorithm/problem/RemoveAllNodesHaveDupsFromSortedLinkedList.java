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
	public ListNode solve(final ListNode data) {
		if (data == null || data.next == null) {
			return data;
		}

		ListNode head = new ListNode(0);
		final ListNode result = head; // dummy result node, finally result.next would be returned.
		ListNode later = data;
		ListNode checker = later.next;

		boolean dup = false;

		while (checker != null) {
			if (checker.val == later.val) {
				dup = true;
			} else {
				if (!dup) {
					head.next = later;
					head = head.next;
				}

				later = checker;
				dup = false;
			}

			checker = checker.next;
		}
		head.next = !dup ? later : null;

		return result.next;
	}

}
