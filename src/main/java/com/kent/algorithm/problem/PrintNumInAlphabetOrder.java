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

    //index of the result array
    private int index;
    @Override
    public int[] solve(Integer data) {
        int[] result = new int[data];
        index = 0;
        for (int i = 1; i <= 9; i++) {
            takeSection(i, data, result);
        }

        return result;
    }

    private void takeSection(int current, int n, int[] result) {
        if (current > n) {
            return;
        }
        result[index++] = current;
        for (int i = 0; i <= 9; i++) {
           takeSection(current*10+i  , n, result);
        }
    }

}
