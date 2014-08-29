package com.kent.algorithm.demo.problem;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.kent.algorithm.Problem;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.BinaryStringWithoutContinuousOne;
import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoType;

/**
 * @author: Kai Yuan
 * Created on 2014-08-29.
 */
@Demo(name="count non-continuous '1' bin-str", type = DemoType.Problems)
public class BinaryStringWithoutContinuousOneDemo extends AbstractDemo {
    Problem<Integer, Integer> problem = new BinaryStringWithoutContinuousOne();
    ImmutableList<Integer> inputs ;

    @Override
    protected void prepareDemo() {
       inputs = ImmutableList.of(1, 2, 3, 5);
    }

    @Override
    protected void specificDemo() {
        for (int i : inputs) {
            printf("Input: %d  Output: %d\n",i, problem.solve(i));
        }
    }

    @Override
    protected String demoDescription() {
        return null;
    }
}
