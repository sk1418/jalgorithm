package com.kent.algorithm.problem;

import com.google.common.collect.Maps;
import com.kent.test.BaseTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * @author: Kent
 * Created on 2014-09-15.
 */
public class PrintRestArrayInRangeTest extends BaseTest{
    @Test
    public void solutionTest() {
        Map<String, Object> input = Maps.newHashMap();
        input.put("min", new Integer(0));
        input.put("max", new Integer(99));
        input.put("array", new int[]{0,1,3,50,75});

        String expected = "[2,4-49,51-74,76-99]";
        PrintRestArrayInRange problem = new PrintRestArrayInRange();
        Assert.assertEquals(expected,problem.solve(input));
    }
}
