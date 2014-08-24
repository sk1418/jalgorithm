package com.kent.algorithm.problem;

import com.kent.algorithm.Problem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 *   Given an int <code>a</code>, and an int <code>d (0&lt;d&lt;10)</code>. Find number <code>b</code>, so that the product of <code>a * b</code> is a number, which
 *   all digits are <code>d</code>. If no b exists, return -1.
 *
 * </p>
 * <p>
 *   E.g. given <code>a=37, d=1</code>, we get b=3, and the result of a*b=111
 * </p>
 *
 * <b>Algorithm</b>
 * <pre>
 *    The quotient of two integers would be one of the followings:
 *    <ul>
 *        <li>1. Integer</li>
 *        <li>2. finite decimal</li>
 *        <li>3. infinite repeating decimal</li>
 *    </ul>
 *
 *   For this problem, we could check dddd..d % a, if the remainder repeated, it is belongs to (3). That is, b doesn't exist for the given a and d.
 *   Each time we do %, add the 10 * a + d to the last remainder.
 *
 * </pre>
 * @author: Kent
 * Created on 2014-08-24.
 */
public class SameDigitsProduct extends Problem<Map<String,Integer>,Map<String, String> > {
    @Override
    public Map<String,String> solve(Map<String, Integer> data) {
        //get the given a
        int a = data.get("a");

        //d (0<d<10) is the  digit , to construct the product, E.g. 7 -> 777..7; 1 -> 11..1
        int d = data.get("d");

        Map<String, String> result = new HashMap<>();// result, contains b and the product

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

        if (len > 0) {
            result.put("product", String.valueOf(d)+"("+len+")");
            result.put("b", stringBuilder.toString());
        } else {
            result.put("product", "-1");
            result.put("b", "-1");

        }
        return result;
    }

    @Override
    public String getBigO() {
        return "";
    }
}
