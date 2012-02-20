package com.kent.algorithm.problem;

import junit.framework.Assert;

import org.junit.Test;

import com.kent.algorithm.Problem;
import com.kent.test.BaseTest;

/**
 * The Class FindMaxSubArrayTest.
 */
public class FindNextHigherNumberTest extends BaseTest {

	/**
	 * Find max sub array test.
	 */
	@Test
	public void testNextHigherNumber() {
		testInfo("FindNextHigherNumberTest");
		final Long input2 = 123456784987654321l;
		final Long input1 = 38276l;
		final Problem<Long, Long> problem = new FindNextHigherNumber();
		final Long result1 = problem.solve(input1);
		final Long result2 = problem.solve(input2);
		final Long expect1 = 38627l;
		final Long expect2 = 123456785123446789l;
		Assert.assertEquals(expect1, result1);
		Assert.assertEquals(expect2, result2);
	}
}
