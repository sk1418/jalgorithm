package com.kent.algorithm.problem;

import com.kent.algorithm.Problem;
import com.kent.test.BaseTest;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author: Kent
 * Created on 2014-09-04.
 */
public class PrintNumInAlphabetOrderTest extends BaseTest{
   private Problem<Integer,String[]> problem = new PrintNumInAlphabetOrder();

    @Test
    public void testSolution() {
        log.debug(Arrays.toString(problem.solve(20)));
    }
}
