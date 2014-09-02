package com.kent.algorithm.demo.problem;

import com.google.common.base.Joiner;
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
        return Joiner.on("\n").join(
            "  Given an integer N, print the count of all binary representations, which has length N and no continuous 1s.",
            "  For example:",
            "  ",
            "      Given N=2, output Result=3 (00, 01, 10)",
            "      Given N=3, output Result=5 (000,001,010,100,101)",
            "  ",
            "      Solution:",
            " ",
            "      we have two different kind of string, ending with 1 or 0.",
            "      let's say:",
            "      ",
            "      zero[i] is the count of those string which has length=i and with 0 at the end",
            "      one[i] is the count of those string which has length=i and with 0 at the end",
            " ",
            "      for getting [i+1] counts, zero[i] could be appended by 0 or 1, but one[i] could only be appended by 0",
            " ",
            "      that is:",
            "      zero[i] = zero[i-1] + one[i-1]",
            "      one[i] = zero[i-1];",
            " ",
            "      Note",
            "      in fact the count would be a Fibonacci sequence. since",
            "      zero[i]+one[i] = zero[i] + zero[i-1]"
        );
    }
}
