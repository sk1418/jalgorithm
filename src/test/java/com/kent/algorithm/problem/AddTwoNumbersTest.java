package com.kent.algorithm.problem;

import static org.junit.Assert.*;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.kent.datastructure.ListNode;
import com.kent.test.BaseTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.Test;

/**
 * The Class FindHeavyIntegerTest.
 */
public class AddTwoNumbersTest extends BaseTest {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(AddTwoNumbersTest.class);

	/**
	 * Solution test.
	 */
	@Test
	public void solutionTest() {
		testInfo("AddTwoNumbersTest");

		final ListNode n1 = new ListNode(7);
		final ListNode n2 = new ListNode(8);
		final ListNode n3 = new ListNode(9);

		final ListNode m1 = new ListNode(9);
		final ListNode m2 = new ListNode(8);

		n1.next = n2;
		n2.next = n3;

		m1.next = m2;

		final List<ListNode> input = ImmutableList.of(n1, m1);

		final AddTwoNumbers problem = new AddTwoNumbers();
		final ListNode result = problem.solve(input);

		final Integer[] expect = new Integer[] { 6, 7, 0, 1 };

		assertArrayEquals(expect, result.toList().toArray(new Integer[0]));
	}
}
