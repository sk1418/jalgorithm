package com.kent.algorithm.demo.problem;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.SameDigitsProduct;
import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoType;

import java.util.Map;

/**
 * @author: Kai Yuan
 * Created on 2014-08-26.
 */

@Demo(name = "Product With Same Digit", type = DemoType.Problems)
public class SameDigitsProductDemo extends AbstractDemo {

    Map<String, Integer> input = Maps.newHashMap();
    Map<String, String> result ;
    SameDigitsProduct problem = new SameDigitsProduct();

    @Override
    protected void warmingUp() {
        //ignored
    }

    @Override
    protected void prepareDemo() {

    }
    private void demo() {
        print(String.format("Input a: %d, d: %d", input.get("a"), input.get("d")));
        result = problem.solve(input);
        input.clear();
        print(String.format("Result b: %s, Product: %s", result.get("b"), result.get("product")));
        printLine("=", 50);
    }

    @Override
    protected void specificDemo() {

        input.put("a", 37);
        input.put("d", 1);
        demo();
        input.put("a", 45);
        input.put("d", 2);
        demo();
        input.put("a", 7657);
        input.put("d", 7);
        demo();
    }

    @Override
    protected String demoDescription() {
        return Joiner.on("\n").join(
            "   Given an int a, and an int d (0&lt;d&lt;10). Find number b, so that the product of a * b is a number, which",
            "   all digits are d. If no b exists, return -1.",
            " ",
            "   E.g. given a=37, d=1, we get b=3, and the result of a*b=111",
            " ",
            " Algorithm",
            "    The quotient of two integers would be one of the followings:",
            "    ",
            "        1. Integer",
            "        2. finite decimal",
            "        3. infinite repeating decimal",
            "    ",
            "   For this problem, we could check dddd..d % a, if the remainder repeated, it is belongs to (3). ",
            "   That is, b doesn't exist for the given a and d.",
            "   Each time we do %, add the 10 * a + d to the last remainder."

        );


    }
}
