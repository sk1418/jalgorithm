package com.kent.algorithm.problem;

import java.util.Map;

import com.kent.algorithm.Problem;
import com.kent.datastructure.ListNode;

/**
 * From http://oj.leetcode.com/problems/linked-list-cycle/
 * <p>
 * Given a linked list, determine if it has a cycle in it.
 * Follow up:
 * Can you solve it without using extra space?
 *
 * </p>
 * 
 * 
 * <b> Algorithm/Solution </b>
 * <p>
 * use two pointers,fast pointer moves 2 nodes once, see if two pointers will meet.
 * </p>
 * 
 * @author kent
 * 
 */
public class DetermineCircleInLinkedList extends Problem<ListNode,Boolean> {

	@Override
	public String getBigO() {
		return "Time: O(n) Space: O(1)";
	}

	@Override
	public Boolean solve(final ListNode data) {
		ListNode slow = data;
		ListNode fast = data;

		while (fast!=null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				return true;
			}
		}

		return false;

	}

}
