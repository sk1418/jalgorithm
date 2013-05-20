package com.kent.algorithm.problem;

import com.kent.algorithm.Problem;
import com.kent.datastructure.ListNode;

/**
 * <p>
 * 
 * Reverse a singly linkedlist.
 * 
 * For example
 * 
 * <pre>
 * {@code
 * [ 1 -> 2 -> 3 -> 4 -> 5 ] to [ 5 -> 4 -> 3 -> 2 -> 1 ]  
 * }</code> .
 * 
 * Your algorithm should use only <b>constant</b> space
 * {@code O(1)}. You may not modify the values in the list, only nodes itself can be changed.
 * 
 * </p>
 * 
 * <b>Solution/Algorithm</b>
 * 
 * <pre>
 *    taking 1 as head
 *    taking 1 as current, 1 is always the current
 *    saving 1.next.next (3) to nn
 * 1) current.next.next = head
 *    head = current.next (2)
 * 2) current.next = nn (1->3)
 * 
 * Iterate the steps above, till end
 * 
 * 
 *   +-(1)+ 
 *   v    |
 *   1    2    3 -> 4 -> 5 -> [Null]
 *   |         ^
 *   +---(2)---+
 * 
 * 
 *   +---(1)---+
 *   v         |
 *   2 -> 1    3    4 -> 5 -> [Null]
 *        |         ^
 *        +---(2)---+
 * 
 * 
 *   +-----(1)------+
 *   v              |
 *   3 -> 2 -> 1    4    5 -> [Null]
 *             |         ^
 *             +---(2)---+
 * 
 * 
 *   +-------(1)---------+
 *   v                   |
 *   4 -> 3 -> 2 -> 1    5    [Null]
 *                  |           ^
 *                  +----(2)----+
 * 
 * 
 *   5 -> 4 -> 3 -> 2 -> 1 -> [Null]
 * </pre>
 * 
 * @author kent
 * 
 */
public class ReverseLinkedList extends Problem<ListNode, ListNode> {

	@Override
	public String getBigO() {
		return "Time: O(n); Space O(1)";
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
