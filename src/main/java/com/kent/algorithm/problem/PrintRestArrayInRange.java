package com.kent.algorithm.problem;

import com.kent.algorithm.Problem;

import java.util.Map;

/**
 * @author: Kent
 * Created on 2014-09-15.
 */
public class PrintRestArrayInRange extends Problem<Map<String, Object>, String> {
    @Override
    public String getBigO() {
        return "Time O(n)";
    }
    @Override
    public String solve(Map<String,Object> data) {
        //get input data
        int[] arr = (int[]) data.get("array");
        int min = (int) data.get("min");
        int max = (int) data.get("max");

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int current = min;
        for (int idx = 0; idx < arr.length; idx++) {
            if (arr[idx] > current)
                sb.append(String.format("%s%s,", current, arr[idx] == current + 1 ? "" : "-" + (arr[idx] - 1)));
            current = arr[idx] + 1;
        }
        sb.append(String.format("%s]", current == max ? max : current + "-" + max));
        return sb.toString();
    }

}
