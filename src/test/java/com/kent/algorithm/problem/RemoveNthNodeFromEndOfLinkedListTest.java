package com.kent.algorithm.problem;

import static org.junit.Assert.*;

import java.util.Map;

import com.google.common.collect.Maps;
import com.kent.algorithm.problem.linkedlist.RemoveNthNodeFromEndOfLinkedList;
import com.kent.datastructure.ListNode;
import com.kent.test.BaseTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.Before;
import org.junit.Test;

/**
 * The Class FindHeavyIntegerTest.
 */
public class RemoveNthNodeFromEndOfLinkedListTest extends BaseTest {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(RemoveNthNodeFromEndOfLinkedListTest.class);

	final ListNode n1 = new ListNode(1);
	final ListNode n2 = new ListNode(2);
	final ListNode n3 = new ListNode(3);
	final ListNode n4 = new ListNode(4);
	final ListNode n5 = new ListNode(5);

	@Before
	public void initList() {

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

	}

    private void initCornerList() {
        n1.next= n2;
        n2.next = null;
    }

	/**
	 * Solution test.
	 */
	@Test
	public void solutionTest() {
		testInfo("Remove the nth node from end of linkedlist");

		final RemoveNthNodeFromEndOfLinkedList problem = new RemoveNthNodeFromEndOfLinkedList();

		final Map<String, Object> input = Maps.newHashMap();
		input.put("head", n1);
		input.put("n", 3);

		ListNode result = problem.solve(input);

		assertEquals("[1 -> 2 -> 4 -> 5]", result.toString());

		initList();
		input.put("n", 5);
		result = problem.solve(input);
		assertEquals("[2 -> 3 -> 4 -> 5]", result.toString());

        initList();
        input.put("n", 1);
        result = problem.solve(input);
        assertEquals("[1 -> 2 -> 3 -> 4]", result.toString());


        //corner case
        initCornerList();
        input.put("n", 1);
        result = problem.solve(input);
		assertEquals("[1]", result.toString());
	}
}
