package com.kent.algorithm.problem;

import com.kent.algorithm.Problem;
import com.kent.test.BaseTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author: Kent
 * Created on 2014-09-04.
 */
public class PrintNumInAlphabetOrderTest extends BaseTest{
   private Problem<Integer,int[]> problem = new PrintNumInAlphabetOrder();

    @Test
    public void testSolution() {
        int[] expected = new int[]{1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 2, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 3, 30, 31, 32, 33, 34, 35, 36, 37, 4, 5, 6, 7, 8, 9};
        Assert.assertArrayEquals(expected, problem.solve(37));
    }
}
