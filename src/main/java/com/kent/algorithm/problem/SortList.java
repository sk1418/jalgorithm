package com.kent.algorithm.problem;

import java.util.Arrays;
import java.util.List;

import com.kent.algorithm.Problem;
import com.kent.datastructure.ListNode;
import com.kent.util.AlgUtil;

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
 * <pre>
 *     - finding the mid node by two pointer, one slow one fast (2x slow)
 *     - then cut the original list into two parts: head->...->mid->null and (mid.next)->..->last->null
 *     - recursively mergesort and merge each part.
 * </pre>
 * </P>
 *
 * @author: Kent
 * Created on 2014-08-13.
 */
public class SortList extends Problem<ListNode, ListNode> {

	@Override
	public String getBigO() {
		return "Time: O(nlog(n)); Space: O(1)";
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
			return list;
		}
		ListNode slow = list;
		ListNode fast = list;
		//mid node, it would the last node of the first half
		ListNode mid = slow;

		//get the middle node
		while (fast != null && fast.next != null) {
			mid = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode right = slow;

		//cut the list into two halves
		mid.next = null;

		list = mergeSortList(list);
		right = mergeSortList(right);
		return merge(list, right);
	}

	//merge two lists with O(1)
	private ListNode merge(ListNode left, ListNode right) {
		//dummy Node
		ListNode result = new ListNode(0);
		ListNode head = result;
		// print info
		if (printSteps()) {
			printMergeStep(left, right);
		}

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

		// print info
		if (printSteps()) {
			printMergeResult(head.next);
		}
		return head.next;
	}


	//print functions just for Demo outputs

	/** only for printing info */
	private static final String MERGING = "Merging : ";
	private static final String PLACE_H = "          ";
	private void printMergeStep(ListNode left, ListNode right) {
		AlgUtil.println(MERGING + left + " <=> " + right);
		AlgUtil.println(PLACE_H + AlgUtil.repeatString(" ", left.toString().length() - 2) + " \\     / ");

	}

	protected void printMergeResult(ListNode list) {
		AlgUtil.println(PLACE_H + AlgUtil.repeatString(" ", list.toString().length() / 4) + list);
		AlgUtil.println("");
	}
}
