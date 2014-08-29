package com.kent.algorithm.problem;

import com.kent.algorithm.Problem;

/**
 * @author: Kai Yuan
 * Created on 2014-08-27.
 */
public class BinaryStringWithoutContinuousOne extends Problem<Integer, Integer> {

    @Override
    public String getBigO() {
        return "Time: O(n)";
    }

    @Override
    public Integer solve(Integer data) {
        int n = data; // the digit length of '01' string
        int result = 1;
        int zero[] = new int[n + 1];
        int one[] = new int[n + 1];

        zero[1] = one[1] = 1;
        for (int i = 2; i <= n; i++) {
            zero[i] = one[i - 1] + zero[i - 1];
            one[i] = zero[i - 1];
        }
        result = one[n] + zero[n];

        return result;
    }
}
