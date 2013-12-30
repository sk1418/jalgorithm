package com.kent.algorithm.problem;

import com.kent.algorithm.Problem;
import com.kent.datastructure.ListNode;
import com.kent.util.AlgUtil;

/**
 * From http://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/
 * <p>
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * </p>
 * 
 * <pre>
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * 
 * </pre>
 * 
 * <b>Solution/Algorithm</b>
 * 
 * [Please read source codes for single pointer solution.]
 * 
 * <pre>
 * - create two pointers (uniq and work)
 * - iterate the following steps:
 *   - if work.next.val == work.val, work goes to next, till a work.next has different value from work
 *   - uniq.next = work.next; uniq = uniq.next; work = work.next;
 * </pre>
 * 
 * @author kent
 * 
 */
public class RemoveDupsFromSortedLinkedList extends Problem<ListNode, ListNode> {

	@Override
	public String getBigO() {
		return "Time: O(n); Space O(1)";
	}

	@Override
	// double pointer solution
	public ListNode solve(ListNode data) {
		if (data == null || data.next == null) {
			return data;
		}

		final ListNode head = data; // head, will be returned at the end
		ListNode uniq = data; // uniq pointer

		while (data != null) {
			// only for demo
			if (printSteps()) {
				AlgUtil.println("[step] uniq  : " + uniq);
				AlgUtil.println("[step] work  : " + data);
				AlgUtil.println("[step] head  : " + head);
				AlgUtil.println(AlgUtil.repeatString("-", 60));
			}
			if (data.next != null && data.next.val == data.val) {
				data = data.next;
				continue;
			} else {
				uniq.next = data.next;
				uniq = uniq.next;
				data = data.next;
			}

		}

		return head;
	}

	// single pointer solution
	public ListNode removeDupSinglePointer(ListNode data) {
		if (data == null || data.next == null) {
			return data;
		}

		ListNode nn; // next of next node

		final ListNode head = data;
		// data is current node
		while (data != null && data.next != null) {
			nn = data.next.next;
			while (data.next != null && data.val == data.next.val) {
				data.next = nn;
				if (nn == null) {
					break;
				}
				nn = nn.next;
			}
			data = data.next;
			// only for demo
			if (printSteps()) {
				AlgUtil.println("step status : " + head);
			}
		}

		return head;
	}

}
