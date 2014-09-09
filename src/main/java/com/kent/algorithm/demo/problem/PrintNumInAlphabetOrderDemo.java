package com.kent.algorithm.demo.problem;

import com.google.common.base.Joiner;
import com.kent.algorithm.Problem;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.PrintNumInAlphabetOrder;
import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoType;

/**
 * @author: Kent
 * Created on 2014-09-09.
 */
@Demo(type = DemoType.Problems, name = "Print Num in Alphabet Ord")
public class PrintNumInAlphabetOrderDemo extends AbstractDemo {
    Problem<Integer, int[]> problem = new PrintNumInAlphabetOrder();
    int input;
    int[] result;

    @Override
    protected void prepareDemo() {
        input = 177;
    }

    @Override
    protected void specificDemo() {
        print("Time complexity:" + problem.getBigO());

        print("\n\nInput N=" + input);
        result = problem.solve(input);
        int c = 0;
        print("Output : ");
        for (int i : result) {
            c++;
            printf("%d%s", i, c % 14 == 0 ? "\n" : ", ");
        }
        print("");
        printLine("=", 50);

    }

    @Override
    protected String demoDescription() {
        return Joiner.on("\n").join(
                "",
                "Print 1 to N in Alphabet order.",
                "For example,",
                "if N = 20, the output should be:",
                "1 10 11 12 13 14 15 16 17 18 19 2 20 21 3 4 5 6 7 8 9",
                "",
                "",
                "Solution: recursive generate the numbers",
                "    1",
                "    10...0",
                "    100001-100009",
                "    10001",
                "    100010-100019",
                "    10002",
                "    100020-100029"
        );
    }
}
