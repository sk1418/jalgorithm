package com.kent.algorithm.problem;

import java.util.Map;

import org.junit.Test;

import com.google.common.collect.Maps;
import com.kent.algorithm.Problem;
import com.kent.test.BaseTest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * The Class Merge2SortedArraysTest
 */
public class Merge2SortedArraysTest extends BaseTest {

	@Test
	public void solutionTest() {
		testInfo("Merge2SortedArrays");
		final int[] A = new int[] {1,3,5,7,9,0,0,0,0,0};
		final int[] B = new int[] {2,4,6,8,10};
		Integer m = 5, n=5;
		Map<String, Object> input = Maps.newHashMap();
		input.put("A", A);
		input.put("B", B);
		input.put("m", m);
		input.put("n", n);

		int[] expected = new int[]{1,2,3,4,5,6,7,8,9,10};
		final Problem<Map<String, Object>, int[]> problem = new Merge2SortedArrays();
		final int[] result = problem.solve(input);
		assertArrayEquals(expected, result);

	}
}
