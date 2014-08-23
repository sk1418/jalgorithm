package com.kent.algorithm.problem;

import com.kent.algorithm.Problem;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * todo
 * @author: Kent
 * Created on 2014-08-24.
 */
public class SameDigitsProduct extends Problem<Map<String,Integer>,String> {
    @Override
    public String solve(Map<String, Integer> data) {
        //get the given a
        int a = data.get("a");

        //d (0<d<10) is the  digit , to construct the product, E.g. 7 -> 777..7; 1 -> 11..1
        int d = data.get("d");

        Set<Integer> rSet = new HashSet<>();

        int r = 0;
        int len = 0;
        StringBuilder stringBuilder = new StringBuilder();
        int q = -1;
        while (true) {
            q = (r*10+d)/a;
            r = (r * 10 + d) % a;
            len ++;

            if (q != 0 || stringBuilder.length() > 0) {
                stringBuilder.append(String.valueOf(q));
            }
            if (r == 0) {
                break;
            }
            if (!rSet.contains(r)) {
                rSet.add(r);
            } else {
                len = -1;
                break;
            }
        }

        return len > 0 ? stringBuilder.toString() : "-1";
    }

    @Override
    public String getBigO() {
        return "";
    }
}
