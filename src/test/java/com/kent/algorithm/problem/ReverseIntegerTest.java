package com.kent.algorithm.problem;

import static org.junit.Assert.*;

import com.kent.test.BaseTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.Test;

/**
 * The Class FindHeavyIntegerTest.
 */
public class ReverseIntegerTest extends BaseTest {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(ReverseIntegerTest.class);

	/**
	 * Solution test.
	 */
	@Test
	public void solutionTest() {
		testInfo("Reverse Integer");
		final ReverseInteger problem = new ReverseInteger();
		final int input1 = 12345;
		final int input2 = -12345;

		int result = problem.solve(input1);
		assertEquals(54321, result);
		result = problem.solve(input2);
		assertEquals(-54321, result);
	}
}
