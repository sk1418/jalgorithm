package com.kent.algorithm.problem;

import static org.junit.Assert.*;

import java.util.Map;

import com.google.common.collect.Maps;
import com.kent.datastructure.ListNode;
import com.kent.test.BaseTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.Test;

/**
 * The Class ReverseLinkedListFromMtoNTest.
 */
public class ReverseLinkedListFromMtoNTest extends BaseTest {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(ReverseLinkedListFromMtoNTest.class);

	/**
	 * Solution test.
	 */
	@Test
	public void solutionTest() {
		testInfo("Reverse Linkedlist from node postion M to N");

		final ListNode n1 = new ListNode(1);
		final ListNode n2 = new ListNode(2);
		final ListNode n3 = new ListNode(3);
		final ListNode n4 = new ListNode(4);
		final ListNode n5 = new ListNode(5);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		final ReverseLinkedListFromMtoN problem = new ReverseLinkedListFromMtoN();

		final Map<String, Object> input = Maps.newHashMap();
		input.put("head", n1);
		input.put("m", 2);
		input.put("n", 4);

		final ListNode result = problem.solve(input);

		assertEquals("[1 -> 4 -> 3 -> 2 -> 5]", result.toString());

	}
}
