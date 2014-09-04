package com.kent.algorithm.problem;

import com.kent.algorithm.Problem;

/**
 * @author: Kent
 * Created on 2014-09-04.
 */
public class PrintNumInAlphabetOrder extends Problem<Integer, String[]> {
    @Override
    public String getBigO() {
        return "Time: O()";
    }

    @Override
    public String[] solve(Integer data) {
        String[] result = new String[data];
        int a = 0;
        for (int i = 1; i <= 9; i++) {
            String t = "" + i;
            result[a++] = t;
            for (int d = 0; d <= 9; d++) {
                if (t.length() > 1)
                    t = t.substring(0, t.length() - 1);
                while (true) {
                    if (Integer.valueOf(t + d) > data)
                        break;
                    t += d;
                    result[a++] = t;
                }
            }
        }

        return result;
    }

}
