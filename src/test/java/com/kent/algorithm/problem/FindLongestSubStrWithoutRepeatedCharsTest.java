package com.kent.algorithm.problem;

import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableMap;
import com.kent.test.BaseTest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * The Class FindHeavyIntegerTest.
 */
public class FindLongestSubStrWithoutRepeatedCharsTest extends BaseTest {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(FindLongestSubStrWithoutRepeatedCharsTest.class);

	/**
	 * Solution test.
	 */
	@Test
	public void solutionTest() {
		testInfo("FindLongestUbStrWithoutRepeatedChars");

		String s1 = ""; // 0
		String s2 = "aaa"; //1
		String s3 = "abcakmcb"; //5
		Map<String, Integer> inputMap =  ImmutableMap.of(s1, 0, s2, 1, s3, 5);


		FindLongestSubStrWithoutRepeatedChars problem = new FindLongestSubStrWithoutRepeatedChars();

		for (String s : inputMap.keySet()) {
			LOG.debug("Now checking: {}", s);
			assertEquals(inputMap.get(s), problem.solve(s));
		}
	}
}
