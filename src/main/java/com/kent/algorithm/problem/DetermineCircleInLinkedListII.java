package com.kent.algorithm.problem;

import com.kent.algorithm.Problem;
import com.kent.datastructure.ListNode;

/**
 * From http://oj.leetcode.com/problems/linked-list-cycle-ii/
 * <p>
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * <p/>
 * Follow up:
 * Can you solve it without using extra space?
 * </p>
 * <p/>
 * <b> Algorithm/Solution </b>
 * <p>
 *     still two nodes, one 2x faster than the slow one. See {@link DetermineCircleInLinkedList}
 *     <li>head is the start node of the list</li>
 *     <li>length between head and the cycle starting is x</li>
 *     <li>length of the cycle is: y</li>
 *     <li>the fast and slow meet at node: m</li>
 *   <br/>
 *   <br/>
 * When the both meet, the length ran by fast is 2x of the length of the slow one:
 *    <pre>
 *        x + m + ky = 2*(x + m + ty)
 *        => ky = 2ty + x + m
 *        => (x+m) % y = 0
 *    </pre>
 *
 * It means that from the length between m and x is x, that is, from m run x step with speed 1 will reach the x node.
 *
 * </p>
 *
 * @author kent
 */
public class DetermineCircleInLinkedListII extends Problem<ListNode,ListNode> {

	@Override
	public String getBigO() {
		return "Time: O(n) Space: O(1)";
	}

	@Override
	public ListNode solve(final ListNode data) {
		ListNode slow = data;
		ListNode fast = data;
		ListNode head =  data;

		boolean hasCycle = false;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast) {
				hasCycle = true;
				break;
			}
		}

		if ( !hasCycle)  {
			return null;
		}

		slow = head;
		while (slow != fast) {
			slow=slow.next;
			fast=fast.next;
		}
		return slow;

	}

}
