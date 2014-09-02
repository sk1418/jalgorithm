package com.kent.algorithm.problem;

import com.kent.algorithm.Problem;

/**
 * <p>
 * Given an integer N, print the count of all binary representations, which has length N and no continuous 1s.
 * For example:
 * <pre>
 *     Given N=2, output Result=3 (00, 01, 10)
 *     Given N=3, output Result=5 (000,001,010,100,101)
 * </pre>
 * </p>
 *
 * <p>
 *     Solution:
 *
 *     we have two different kind of string, ending with 1 or 0.
 *     let's say:
 *     <pre>
 *     zero[i] is the count of those string which has length=i and with 0 at the end
 *     one[i] is the count of those string which has length=i and with 0 at the end
 *
 *     for getting [i+1] counts, zero[i] could be appended by 0 or 1, but one[i] could only be appended by 0
 *
 *     that is:
 *     zero[i] = zero[i-1] + one[i-1]
 *     one[i] = zero[i-1];
 *
 *     <b>Note</b>
 *     in fact the count would be a Fibonacci sequence. since
 *     zero[i]+one[i] = zero[i] + zero[i-1]
 *     </pre>
 *
 *
 * </p>
 * @author: Kent
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
