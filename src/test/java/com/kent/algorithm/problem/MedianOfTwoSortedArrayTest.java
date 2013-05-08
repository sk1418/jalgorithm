/*
 * 
 */
package com.kent.algorithm.problem;

import static org.junit.Assert.*;

import java.util.List;

import com.google.common.collect.Lists;
import com.kent.test.BaseTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.Test;

/**
 * The Class MiscTest.
 */
public class MedianOfTwoSortedArrayTest extends BaseTest {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(MedianOfTwoSortedArrayTest.class);

	/**
	 * Count inversions test.
	 */
	@Test
	public void countInversionsTest() {
		testInfo("Media of two sorted array");
		final int[] a1 = new int[] { 2, 5 };
		final int[] b1 = new int[] { 1, 3, 4, 6, 7, 8, 9 };
		final List<int[]> input1 = Lists.newArrayList();
		input1.add(a1);
		input1.add(b1);

		final double r1 = 5;

		final MedianOfTwoSortedArrays problem = new MedianOfTwoSortedArrays();
		final double result = problem.solve(input1);
		assertEquals(r1, result, 0.01);
	}
}
