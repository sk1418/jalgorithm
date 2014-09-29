package com.kent.algorithm.problem;

import static org.junit.Assert.*;

import java.util.Map;

import com.google.common.collect.Maps;
import com.kent.algorithm.problem.linkedlist.ReverseLinkedListEveryKNodes;
import com.kent.datastructure.ListNode;
import com.kent.test.BaseTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.Test;

/**
 * The Class FindHeavyIntegerTest.
 */
public class ReverseLinkedListEveryKNodesTest extends BaseTest {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(ReverseLinkedListEveryKNodesTest.class);

	/**
	 * Solution test.
	 */
	@Test
	public void solutionTest() {
		testInfo("Reverse Linkedlist every K nodes");

		final ListNode n1 = new ListNode(1);
		final ListNode n2 = new ListNode(2);
		final ListNode n3 = new ListNode(3);
		final ListNode n4 = new ListNode(4);
		final ListNode n5 = new ListNode(5);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		final ReverseLinkedListEveryKNodes problem = new ReverseLinkedListEveryKNodes();

		final Map<String, Object> input = Maps.newHashMap();
		input.put("head", n1);
		input.put("k", 2);

		final ListNode result = problem.solve(input);

		assertEquals("[2 -> 1 -> 4 -> 3 -> 5]", result.toString());

	}
}
