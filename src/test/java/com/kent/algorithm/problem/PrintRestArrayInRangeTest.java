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
        input.put("min", 0);
        input.put("max", 99);
        input.put("array", new int[]{0,1,3,50,75});

        String expected = "[2,4-49,51-74,76-99]";
        String expected2 = "[2,4-49,51-74,76-98]";
        String expected3 = "[2,4-49,51-74,76-97,99]";
        PrintRestArrayInRange problem = new PrintRestArrayInRange();
        Assert.assertEquals(expected,problem.solve(input));
        input.put("array", new int[]{0, 1, 3, 50, 75, 99});
        Assert.assertEquals(expected2,problem.solve(input));
        input.put("array", new int[]{0, 1, 3, 50, 75, 98});
        Assert.assertEquals(expected3, problem.solve(input));
        //test full array
        int[] full = new int[100];
        for (int i = 0; i <= 99; i++) {
            full[i]=i;
        }
        input.put("array", full);
        Assert.assertEquals("[]", problem.solve(input));

        //test empty array
        input.put("array", new int[]{});
        Assert.assertEquals("[0-99]", problem.solve(input));

    }
}
