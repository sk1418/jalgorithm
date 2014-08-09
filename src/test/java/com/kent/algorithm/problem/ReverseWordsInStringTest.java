package com.kent.algorithm.problem;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kent.test.BaseTest;

import static org.junit.Assert.assertEquals;

/**
 * The Class ReverseWordsInStringTest
 */
public class ReverseWordsInStringTest extends BaseTest {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(ReverseWordsInStringTest.class);

	/**
	 * Solution test.
	 */
	@Test
	public void solutionTest() {
		testInfo("Reverse Words in String");
		final ReverseWordsInString problem = new ReverseWordsInString();
		final String expect = "c b a";
		final String input1 = "";
		final String input2 = " a b c ";
		final String input3 = " a    b c  ";

		String result = problem.solve(input1);
		assertEquals("", result);
		result = problem.solve(input2);
		assertEquals(expect, result);
		result = problem.solve(input3);
		assertEquals(expect, result);
	}
}
