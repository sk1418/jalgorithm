package com.kent.algorithm.demo.problem;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import com.kent.algorithm.Problem;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.PrintRestArrayInRange;
import com.kent.algorithm.ui.Demo;

import java.util.Arrays;
import java.util.Map;

import static com.kent.util.AlgUtil.repeatString;

/**
 * @author: Kent
 * Created on 2014-09-16.
 */
@Demo(name = "Print Rest Array In Range")
public class PrintRestArrayInRangeDemo extends AbstractDemo {
    PrintRestArrayInRange problem = new PrintRestArrayInRange();
    Map<String, Object> input;

    @Override

    protected void prepareDemo() {
        input = Maps.newHashMap();
        input.put("min", 0);
        input.put("max", 99);
        input.put("array", new int[]{0, 1, 3, 50, 75});

    }

    @Override
    protected void specificDemo() {

        print(String.format("Complexity: %s\n", problem.getBigO()));
        print("Inputs:");
        printf("min:%d  max:%d\n", input.get("min"), input.get("max"));
        print("array: " + Arrays.toString((int[]) input.get("array")));
        stopwatch.start();
        print("Output:" + problem.solve(input));
        print(repeatString("=", 50));
        stopwatch.stop();
        print(stopwatch.readAsString());
        stopwatch.reset();
        //2nd demo
        input.put("min", 0);
        input.put("max", 10);
        input.put("array", new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10});

        print("Inputs: (complete array demo)");
        printf("min:%d  max:%d\n", input.get("min"), input.get("max"));
        print("array: " + Arrays.toString((int[]) input.get("array")));
        stopwatch.start();
        print("Output:" + problem.solve(input));
        print(stopwatch.readAsString());
        stopwatch.stop();
        print(repeatString("=", 50));
        stopwatch.reset();
    }

    @Override
    protected String demoDescription() {
        return Joiner.on("\n").join(
                " Given a sorted integer array with positive unique numbers between min and max.",
                " Print/return the rest element from the min-max sequence in range.",
                "",
                " Example:",
                "     array: [0,1,3,50,75] min:0, max:99",
                "     output in string: [2,4-49,51-74,76-99]"
        );
    }
}
