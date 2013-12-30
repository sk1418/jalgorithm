package com.kent.algorithm.problem;

import java.util.Map;

import com.kent.algorithm.Problem;
import com.kent.datastructure.ListNode;

/**
 * From http://oj.leetcode.com/problems/reverse-linked-list-ii/
 * <p>
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example,
 * 
 * <pre>
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 
 * return 1->4->3->2->5->NULL.
 * </pre>
 * 
 * Note: Given m, n satisfy the following condition: 1 =< m =< n =< length of list.
 * </p>
 * 
 * <b>Solution/Algorithm</b>
 * 
 * <pre>
 * 1) if empty node or single node list or m==n return the head immediately
 * 2) find out the mth node, also save the (m-1)th node as pre
 * 3) do reverse from the mth node (n-m) times. hold the head node(newHead) of reversed part of list.
 * 4) if pre is not null, set pre.next= newHead
 * 
 * 
 * </pre>
 * 
 * @see ReverseLinkedList
 * @see ReverseLinkedListEveryKNodes
 * @author kent
 * 
 */
public class ReverseLinkedListFromMtoN extends Problem<Map<String, Object>, ListNode> {

	@Override
	public String getBigO() {
		return "Time: O(n); Space O(1)";
	}

	@Override
	public ListNode solve(final Map<String, Object> data) {
		final int m = (Integer) data.get("m");
		final int n = (Integer) data.get("n");
		ListNode head = (ListNode) data.get("head");

		if (head == null || head.next == null || m == n) {
			return head;
		}
		ListNode node = head;

		// find the mth node, also the pre (m-1)th
		ListNode pre = null;
		for (int i = 1; i <= m - 1; i++) {
			pre = node;
			node = node.next;
		}

		// here do reverse n-m times
		ListNode nn = null;
		ListNode newHead = node;
		for (int i = 1; i <= n - m; i++) {
			nn = node.next.next;
			node.next.next = newHead;
			newHead = node.next;
			node.next = nn;
		}

		if (pre != null) {// m>1
			pre.next = newHead;
		} else {
			head = newHead;
		}

		return head;

	}

}
