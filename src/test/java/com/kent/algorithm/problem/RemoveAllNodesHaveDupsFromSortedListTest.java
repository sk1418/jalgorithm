package com.kent.algorithm.problem;

import static org.junit.Assert.*;

import com.kent.algorithm.problem.linkedlist.RemoveAllNodesHaveDupsFromSortedLinkedList;
import com.kent.datastructure.ListNode;
import com.kent.test.BaseTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.Test;

/**
 * The Class FindHeavyIntegerTest.
 */
public class RemoveAllNodesHaveDupsFromSortedListTest extends BaseTest {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(RemoveAllNodesHaveDupsFromSortedListTest.class);

	/**
	 * Solution test.
	 */
	@Test
	public void solutionTest() {

		// 1,1,2,3,3,4,5,5,6
		final ListNode na = new ListNode(1);
		final ListNode n2 = new ListNode(1);
		final ListNode n3 = new ListNode(2);
		final ListNode n4 = new ListNode(3);
		final ListNode n5 = new ListNode(3);
		final ListNode n6 = new ListNode(4);
		final ListNode n7 = new ListNode(5);
		final ListNode n8 = new ListNode(5);
		final ListNode n9 = new ListNode(6);

		na.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;

		// 1,1
		final ListNode nb = new ListNode(1);
		final ListNode b2 = new ListNode(1);
		nb.next = b2;

		// 1,1,2
		final ListNode nc = new ListNode(1);
		final ListNode c2 = new ListNode(1);
		final ListNode c3 = new ListNode(2);
		nc.next = c2;
		c2.next = c3;

		final RemoveAllNodesHaveDupsFromSortedLinkedList problem = new RemoveAllNodesHaveDupsFromSortedLinkedList();
		problem.setPrintSteps(true);
		ListNode result = problem.solve(na);
		assertEquals("[2 -> 4 -> 6]", result.toString());
		result = problem.solve(nb);
		assertNull(result);
		result = problem.solve(nc);
		assertEquals("[2]", result.toString());
	}
}
