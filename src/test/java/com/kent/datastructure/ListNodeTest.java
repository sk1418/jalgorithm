/*
 * 
 */
package com.kent.datastructure;

import java.util.List;

import com.kent.test.BaseTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.Assert;
import org.junit.Test;

/**
 * The Class MiscTest.
 */
public class ListNodeTest extends BaseTest {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(ListNodeTest.class);

	/**
	 * Count inversions test.
	 */
	@Test
	public void toList() {
		testInfo("ListNodeTest toList");
		final ListNode n1 = new ListNode(1);
		final ListNode n2 = new ListNode(2);
		final ListNode n3 = new ListNode(3);
		final ListNode n4 = new ListNode(4);
		final ListNode n5 = new ListNode(5);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		final Integer[] expect = new Integer[] { 1, 2, 3, 4, 5 };
		final List<Integer> l = n1.toList();

		final Integer[] result = l.toArray(new Integer[0]);
		Assert.assertArrayEquals(expect, result);
	}

}
