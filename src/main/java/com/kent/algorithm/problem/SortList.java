package com.kent.algorithm.problem;

import java.util.List;

import com.kent.algorithm.Problem;
import com.kent.datastructure.ListNode;

/**
 * From https://oj.leetcode.com/problems/sort-list/
 * <p/>
 * <P>
 * Problem:  Sort a linked list in <pre>O(n log n)</pre> time using constant space complexity.
 * </p>
 * <p/>
 * <p/>
 * <b>Solution:</b>
 * Merge sort with List could do in-place merge!
 * </P>
 *
 * @author: Kent
 * Created on 2014-08-13.
 */
public class SortList extends Problem<ListNode, ListNode> {

	@Override
	public String getBigO() {
		return "O(nlog(n)); Space: O(1)";
	}

	@Override
	public ListNode solve(ListNode data) {
		if (data == null || data.next == null) {
			return data;
		}

		return mergeSortList(data);


	}


	private ListNode mergeSortList(ListNode list) {
		if (list.next == null) {
			return null;
		}
		//get the middle node
		ListNode slow = list;
		ListNode fast = list;
		ListNode mid = slow;
		while (fast != null && fast.next != null) {
			mid = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode r = slow;

		//cut the list into two
		mid.next = null;

		mergeSortList(list);
		mergeSortList(r);
		return merge(list, r);
	}

	private ListNode merge(ListNode left, ListNode right) {
		//dummy Node
		ListNode result = new ListNode(0);
		ListNode head = result;
		while (left != null && right != null) {

			if ( left.val <= right.val) {
				result.next= left;
				left = left.next;
			}else {
				result.next = right;
				right = right.next ;
			}
			result = result.next;
		}
		if (left == null) {
			result.next = right;
		} else {
			result.next = left;
		}
		return head.next;
	}
}
