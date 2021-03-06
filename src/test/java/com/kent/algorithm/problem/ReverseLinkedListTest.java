package com.kent.algorithm.problem;

import static org.junit.Assert.*;

import com.kent.algorithm.problem.linkedlist.ReverseLinkedList;
import com.kent.datastructure.ListNode;
import com.kent.test.BaseTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.Test;

/**
 * The Class FindHeavyIntegerTest.
 */
public class ReverseLinkedListTest extends BaseTest {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(ReverseLinkedListTest.class);

	/**
	 * Solution test.
	 */
	@Test
	public void solutionTest() {
		testInfo("Reverse Linkedlist");

		final ListNode n1 = new ListNode(1);
		final ListNode n2 = new ListNode(2);
		final ListNode n3 = new ListNode(3);
		final ListNode n4 = new ListNode(4);
		final ListNode n5 = new ListNode(5);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		final ReverseLinkedList problem = new ReverseLinkedList();
		final ListNode result = problem.solve(n1);

		assertEquals("[5 -> 4 -> 3 -> 2 -> 1]", result.toString());

	}
}
