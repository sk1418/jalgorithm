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
 * <pre>
 * Assume the given list with head node "data"
 * - if data==null or data.next == null, data is the answer
 * - create two pointer, one named later, one name checker, and a dup boolean flag
 * - create one head node with dummy value. result pointer points to head. the result.next would be answer
 * - later->data; checker->data.next
 * - if checker!=null iterate following steps:
 *   > later.val == checker.val? checker goes to next node, set dup flag=true, next iteration
 *   > if later.val!=checker.val
 *         if dup==false? head->later, head->head.next
 *         reset dup flag later->checker, checker->checker.next; next iteration
 *   > after last iteration, we need to check if the current later should be in answer:
 *     head.next = !dup ? later : null;
 *   > return result.next
 * 
 * </pre>
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
