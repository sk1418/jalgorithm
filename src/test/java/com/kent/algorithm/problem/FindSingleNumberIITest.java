package com.kent.algorithm.problem;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kent.algorithm.Problem;
import com.kent.test.BaseTest;

import static org.junit.Assert.assertEquals;

/**
 * @author: Kent
 * Created on 2014-05-07.
 */
public class FindSingleNumberIITest extends BaseTest {
	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(FindSingleNumberIITest.class);

	/**
	 * Solution test.
	 */
	@Test
	public void solutionTest() {
		int[] input = new int[]{1, 1, 1, 5, 6, 7, 5, 6, 7, 5, 6, 7, 9};
		Problem<int[], Integer> problem = new FindSingleNumberII();
		int x =  problem.solve(input);
		assertEquals(9, x);
	}
}
