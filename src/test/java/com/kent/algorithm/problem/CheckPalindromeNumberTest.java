package com.kent.algorithm.problem;

import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableMap;
import com.kent.test.BaseTest;

import static org.junit.Assert.assertEquals;

/**
 * @author: Kent
 * Created on 2014-04-30.
 */
public class CheckPalindromeNumberTest extends BaseTest {
	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(CheckPalindromeNumber.class);

	/**
	 * Solution test.
	 */
	@Test
	public void solutionTest() {
		testInfo("CheckPalindromeNumber");
		Integer i1 = 0;
		Integer i2 =-123;
		Integer i3 = 1234554321;
		Integer i4 = 1000101;
		Integer i5 = 1010101;

		Map<Integer, Boolean> inputMap =  ImmutableMap.of(
			i1, true,
			i2, false,
			i3, true,
			i4, false,
			i5, true
		);


		CheckPalindromeNumber problem = new CheckPalindromeNumber();
		for (Integer i : inputMap.keySet()) {
			LOG.debug("Now checking: {}", i);
			assertEquals(inputMap.get(i), problem.solve(i));
		}
	}
}
