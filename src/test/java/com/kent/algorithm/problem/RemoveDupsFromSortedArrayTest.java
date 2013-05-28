package com.kent.algorithm.problem;

import static org.junit.Assert.*;

import com.kent.algorithm.Problem;
import com.kent.test.BaseTest;

import org.junit.Test;

/**
 * The Class RemoveDupsFromSortedArrayTest.
 */
public class RemoveDupsFromSortedArrayTest extends BaseTest {

	@Test
	public void removeDupsFromSortedArrayTest() {
		testInfo("RemoveDupsFromSortedArray");
		final int[] testArray = new int[] { 1, 1, 2, 3, 3, 4, 5, 5, 5, 5 };
		final Problem<int[], Integer> problem = new RemoveDupsFromSortedArray();
		final int result = problem.solve(testArray);
		assertEquals(5, result);

	}
}
