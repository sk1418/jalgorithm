/*
 * 
 */
package com.kent.datastructure;

import java.util.List;

import com.kent.test.BaseTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The Class MiscTest.
 */
public class ListNodeTest extends BaseTest {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(ListNodeTest.class);
	final ListNode n1 = new ListNode(1);
	final ListNode n2 = new ListNode(2);
	final ListNode n3 = new ListNode(3);
	final ListNode n4 = new ListNode(4);
	final ListNode n5 = new ListNode(5);

	@Before
	public void init() {

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

	}

	/**
	 */
	@Test
	public void oListTest() {
		testInfo("ListNodeTest toList");

		final Integer[] expect = new Integer[] { 1, 2, 3, 4, 5 };
		final List<Integer> l = n1.toList();

		final Integer[] result = l.toArray(new Integer[0]);
		Assert.assertArrayEquals(expect, result);
	}

	@Test
	public void toStringTest() {
		testInfo("ListNodeTest toString");

		final String expect = "[1 -> 2 -> 3 -> 4 -> 5]";
		final String s = n1.toString();

		Assert.assertEquals(expect, s);
	}

}
