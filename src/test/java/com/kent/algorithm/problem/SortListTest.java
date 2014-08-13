package com.kent.algorithm.problem;

import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;
import com.kent.datastructure.ListNode;
import com.kent.test.BaseTest;

import static org.junit.Assert.assertEquals;

/**
 * @author: Kent
 * Created on 2014-08-13.
 */
public class SortListTest extends BaseTest{
	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(SortListTest.class);

	/**
	 * Solution test.
	 */
	@Test
	public void solutionTest() {
		testInfo("sort list");

		final ListNode n1 = new ListNode(8);
		final ListNode n2 = new ListNode(7);
		final ListNode n3 = new ListNode(1);
		final ListNode n4 = new ListNode(4);
		final ListNode n5 = new ListNode(5);
		final ListNode n6 = new ListNode(2);
		final ListNode n7 = new ListNode(3);
		final ListNode n8 = new ListNode(6);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;

		final SortList problem = new SortList();

		final ListNode input = n1;
		final ListNode result = problem.solve(input);

		assertEquals("[1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8]", result.toString());

	}

}
