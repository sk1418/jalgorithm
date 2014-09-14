package com.kent.algorithm.problem;

import com.google.common.collect.Lists;
import com.kent.algorithm.Problem;
import com.kent.test.BaseTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: Kent
 * Created on 2014-09-04.
 */
public class PrintNumInAlphabetOrderTest extends BaseTest{
   private Problem<Integer,int[]> problem = new PrintNumInAlphabetOrder();

    @Test
    public void testSolution() {
        int n=90;
        int[] expected = new int[n];
        List<String> expectedStr = Lists.newArrayList();
        for (int i = 1; i <=n; i++) {
            expectedStr.add(String.valueOf(i));
        }
        Collections.sort(expectedStr);
        for (int i =0;i<expectedStr.size();i++) {
            expected[i] = Integer.valueOf(expectedStr.get(i));
        }

//            log.debug(Arrays.toString(problem.solve(n)));
            Assert.assertArrayEquals(expected, problem.solve(n));
        }
}
