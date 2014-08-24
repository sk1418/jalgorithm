package com.kent.algorithm.problem;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.kent.algorithm.Problem;
import com.kent.test.BaseTest;
import junit.framework.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author: Kent
 * Created on 2014-08-24.
 */
public class SameDigitsProductTest extends BaseTest {
   /** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(SameDigitsProductTest.class);

	/**
	 * Solution test.
	 */
	@Test
	public void solutionTest() {
        testInfo("Same Digit Product");
        Map<String, Integer> input = ImmutableMap.of("a",21, "d", 1);
        SameDigitsProduct problem = new SameDigitsProduct();
        Assert.assertEquals("5291",problem.solve(input).get("b"));
        input = ImmutableMap.of("a",28, "d", 1);
        Assert.assertEquals("-1",problem.solve(input).get("b"));
    }
   }

