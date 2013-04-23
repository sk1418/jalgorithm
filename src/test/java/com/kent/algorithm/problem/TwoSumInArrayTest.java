/*
 * 
 */
package com.kent.algorithm.problem;

import java.util.Map;

import com.google.common.collect.Maps;
import com.kent.algorithm.Problem;
import com.kent.test.BaseTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.Assert;
import org.junit.Test;

/**
 * The Class MiscTest.
 */
public class TwoSumInArrayTest extends BaseTest {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(TwoSumInArrayTest.class);

	/**
	 * Count inversions test.
	 */
	@Test
	public void countInversionsTest() {
		testInfo("two sum in Array");
		final Map<String, Object> input1 = Maps.newHashMap();
		final Map<String, Object> input2 = Maps.newHashMap();
		final Map<String, Object> input3 = Maps.newHashMap();
		final Map<String, Object> input4 = Maps.newHashMap();

		final int[] a1 = new int[] { 5, 75, 25 };
		final int[] output1 = new int[] { 2, 3 };
		input1.put("array", a1);
		input1.put("target", 100);

		final int[] a2 = new int[] { 150, 24, 79, 50, 88, 345, 3 };
		final int[] output2 = new int[] { 1, 4 };
		input2.put("array", a2);
		input2.put("target", 200);

		final int[] a3 = new int[] { 210, 582, 622, 337, 626, 580, 994, 299, 386, 274, 591, 921, 733, 851, 770, 300, 380, 225, 223, 861, 851, 525,
				206, 714, 985, 82, 641, 270, 5, 777, 899, 820, 995, 397, 43, 973, 191, 885, 156, 9, 568, 256, 659, 673, 85, 26, 631, 293, 151, 143,
				423 };
		final int[] output3 = new int[] { 40, 46 };
		input3.put("array", a3);
		input3.put("target", 35);

		final int[] a4 = new int[] { 2, 1, 9, 4, 4, 56, 90, 3 };
		final int[] output4 = new int[] { 4, 5 };
		input4.put("array", a4);
		input4.put("target", 8);

		final Problem<Map<String, Object>, int[]> problem = new TwoSumInArray();
		int[] result = problem.solve(input1);
		Assert.assertArrayEquals(output1, result);
		result = problem.solve(input2);
		Assert.assertArrayEquals(output2, result);
		result = problem.solve(input3);
		Assert.assertArrayEquals(output3, result);
		result = problem.solve(input4);
		Assert.assertArrayEquals(output4, result);
	}

}
