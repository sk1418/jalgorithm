package com.kent.algorithm.problem;

import com.kent.algorithm.Problem;

/**
 * <p>
 * Print 1 to N in Alphabet order.
 * For example,
 * <pre>if N = 20, the output should be:
 * 1 10 11 12 13 14 15 16 17 18 19 2 20 21 3 4 5 6 7 8 9
 * </pre>
 *
 * <p/>
 * <p>
 * solution: recursive generate the numbers
 *     1
 *     10...0
 *     100001-100009
 *     10001
 *     100010-100019
 *     10002
 *     100020-100029
 * </p>
 *
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
            takeSection(current * 10 + i, n, result);
        }
    }

}
