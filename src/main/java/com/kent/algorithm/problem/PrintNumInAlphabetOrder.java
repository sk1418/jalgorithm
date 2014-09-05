package com.kent.algorithm.problem;

import com.kent.algorithm.Problem;

/**
 * @author: Kent
 * Created on 2014-09-04.
 */
public class PrintNumInAlphabetOrder extends Problem<Integer, int[]> {
    @Override
    public String getBigO() {
        return "Time: O(n)";
    }

    @Override
    public int[] solve(Integer data) {
        int[] result = new int[data];
        int a = 0;
        for (int i = 1; i <= 9; i++) {
            int t = i;
            result[a++] = t;
            for (int d = 0; d <= 9; d++) {
                //if t has two digits, cut the last one
                if (t >= 10)
                    t /= 10;
                while (true) {
                    if (10 * t + d > data)
                        break;
                    t = 10 * t + d;
                    result[a++] = t;
                }
            }
        }

        return result;
    }

}
