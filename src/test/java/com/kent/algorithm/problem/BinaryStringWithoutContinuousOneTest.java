package com.kent.algorithm.problem;

import com.kent.algorithm.Problem;
import com.kent.test.BaseTest;
import junit.framework.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: Kai Yuan
 * Created on 2014-08-27.
 */
public class BinaryStringWithoutContinuousOneTest extends BaseTest{

    @Test
    public void solutionTest() {
        Problem<Integer, Integer> problem = new BinaryStringWithoutContinuousOne();

        Assert.assertEquals(new Integer(2), problem.solve(1));
        Assert.assertEquals(new Integer(3), problem.solve(2));
        Assert.assertEquals(new Integer(5), problem.solve(3));

    }
    
}
