package com.kent.algorithm.problem;

import com.kent.algorithm.Problem;

import java.util.Map;

/**
 * Given a sorted integer array with positive unique numbers between min and max.
 * Print/return the rest element from the min-max sequence in range.
 *
 * Example:
 * <pre>
 *     array: [0,1,3,50,75] min:0, max:99
 *     output in string: [2,4-49,51-74,76-99]
 * </pre>
 * @author: Kent
 * Created on 2014-09-15.
 */
public class PrintRestArrayInRange extends Problem<Map<String, Object>, String> {
    @Override
    public String getBigO() {
        return "Time O(n)";
    }

    @Override
    public String solve(Map<String, Object> data) {
        //get input data
        int[] arr = (int[]) data.get("array");
        int min = (int) data.get("min");
        int max = (int) data.get("max");

        StringBuilder sb = new StringBuilder();
        boolean hasElement = false;
        sb.append("[");
        int current = min;
        for (int idx = 0; idx < arr.length; idx++) {
            if (arr[idx] > current) {
                sb.append(String.format("%s%s%s", hasElement ? "," : "", current,
                         arr[idx] == current + 1 ? "" : "-" + (arr[idx] - 1)));
                hasElement = true;
            }
            current = arr[idx] + 1;
        }
        if (current <= max)
            sb.append(String.format("%s%s", hasElement?",":"", current == max ? max : current + "-" + max));
        sb.append("]");
        return sb.toString();
    }

}
