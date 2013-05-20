package com.kent.algorithm.problem;

import com.kent.algorithm.Problem;
import com.kent.datastructure.ListNode;

/**
 * <p>
 * 
 * For example
 * 
 * <pre>
 * {@code
 * [ 1 -> 2 -> 3 -> 4 -> 5 ] to [ 5 -> 4 -> 3 -> 2 -> 1 ]  
 * }</code> .
 * 
 * Your algorithm should use only <b>constant</b> space. You may not modify the values in the list, only nodes itself can be changed.
 * 
 * </p>
 * 
 * <b>Solution/Algorithm</b>
 * 
 * tbd
 * 
 * @author kent
 * 
 */
public class ReverseLinkedList extends Problem<ListNode, ListNode> {

	@Override
	public String getBigO() {
		return "O(n)";
	}

	@Override
	public ListNode solve(final ListNode data) {
		ListNode nn; // next of next node

		if (data == null || data.next == null) {
			return data;
		}

		// initial newHead is the head of date (date)
		ListNode newHead = data;
		// data is current node
		while (data != null && data.next != null) {
			nn = data.next.next;
			data.next.next = newHead; // move the data.next to the head
			newHead = data.next; // date.next becomes newHead
			data.next = nn; // data.next -> nn
		}

		return newHead;
	}

}
