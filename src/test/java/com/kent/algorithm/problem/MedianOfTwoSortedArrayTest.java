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
	 * Median of two sorted array
	 */
	@Test
	public void solutionTest() {
		testInfo("Median of two sorted array");

		final List<int[]> input = Lists.newArrayList();
		final MedianOfTwoSortedArrays problem = new MedianOfTwoSortedArrays();

		final int[] a1 = new int[] { 2, 5 };
		final int[] b1 = new int[] { 1, 3, 4, 6, 7, 8, 9 };
		input.add(a1);
		input.add(b1);
		final double r1 = 5;
		double result = problem.solve(input);
		assertEquals(r1, result, 0.01);

		final int[] a2 = new int[] { 5, 6, 7, 8, 9 };
		final int[] b2 = new int[] { 1, 2, 3, 4, 10 };
		input.clear();
		input.add(a2);
		input.add(b2);
		final double r2 = 5.5;
		result = problem.solve(input);
		assertEquals(r2, result, 0.01);

		final int[] a3 = new int[] { 4 };
		final int[] b3 = new int[] { 1, 2, 3 };
		input.clear();
		input.add(a3);
		input.add(b3);
		final double r3 = 2.5;
		result = problem.solve(input);
		assertEquals(r3, result, 0.01);

		final int[] a4 = new int[] {};
		final int[] b4 = new int[] { 1, 2, 3, 4 };
		input.clear();
		input.add(a4);
		input.add(b4);
		final double r4 = 2.5;
		result = problem.solve(input);
		assertEquals(r4, result, 0.01);

		final int[] a5 = new int[] { 1 };
		final int[] b5 = new int[] { 2, 3 };
		input.clear();
		input.add(a5);
		input.add(b5);
		final double r5 = 2;
		result = problem.solve(input);
		assertEquals(r5, result, 0.01);
	}
}
