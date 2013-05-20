package com.kent.algorithm.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kent.algorithm.Problem;
import com.kent.datastructure.ListNode;

/**
 * <p>
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list. If the number of nodes is not a multiple of k
 * then left-out nodes in the end should remain as it is. You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory space: O(1) is allowed.
 * 
 * For example,
 * 
 * <pre>
 * Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * </pre>
 * 
 * </p>
 * 
 * <b>Solution/Algorithm</b>
 * 
 * 
 * 
 * <pre>
 *     newHead would be the result node to be returned 
 *    0) if the given node(head) is null or head.next is null, return head
 *    1) get length of the whole list "l"
 *    2) if k>l return head
 *    3) iterate following process l/k times:
 *    4)
 *      -reverse the list from head till k-1 nodes after head (@see ReverseLinkedList)
 *      - take the reversed first and last node
 *      - if newHead is null, set newHead = first (this will be done in first iteration)
 *      - tail is the "last" of pervious iteration. init value null
 *          if (tail != null) {
 * 				tail.next = first;
 * 			}
 * 			tail = last;
 *      - set head = tail.next
 * 
 * 
 * 
 * </pre>
 * 
 * @see ReverseLinkedList
 * @author kent
 * 
 */
public class ReverseLinkedListEveryKNodes extends Problem<Map<String, Object>, ListNode> {

	@Override
	public String getBigO() {
		return "Time: O(n); Space O(1)";
	}

	@Override
	public ListNode solve(final Map<String, Object> data) {
		final int k = (Integer) data.get("k");
		ListNode head = (ListNode) data.get("head");

		if (head == null || head.next == null || k <= 1) {
			return head;
		}
		ListNode node = head;
		int l = 1; // total length of the list
		while (node.next != null) {
			l++;
			node = node.next;
		}

		if (l < k) {
			return head;
		}

		ListNode newHead = null; // would be the final result

		List<ListNode> retList = null;
		ListNode tail = null;
		for (int i = 1; i <= l / k; i++) {

			retList = reverseGivenNodes(head, k - 1);
			newHead = i == 1 ? retList.get(0) : newHead;
			if (tail != null) {
				tail.next = retList.get(0);
			}
			tail = retList.get(1);

			// prepare for next round
			head = tail.next;
		}

		return newHead;
	}

	/**
	 * reverse a list from the given node as start node. total reversed nodes number: t
	 * 
	 * @param node
	 * @param t
	 * @return
	 */
	private List<ListNode> reverseGivenNodes(final ListNode node, int t) {
		final List<ListNode> retval = new ArrayList<ListNode>();
		ListNode nn; // next of next node

		// initial newHead is the head of date (date)
		ListNode newHead = node;
		// data is current node
		while (t > 0) {
			nn = node.next.next;
			node.next.next = newHead; // move the data.next to the head
			newHead = node.next; // date.next becomes newHead
			node.next = nn;
			t--;
		}

		retval.add(newHead);
		retval.add(node);
		return retval;
	}

}
