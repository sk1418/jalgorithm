package com.kent.algorithm.problem;

import com.kent.algorithm.Problem;

/**
 * <p>
 * Reverse digits of an integer.
 * </p>
 * 
 * <pre>
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * </pre>
 * 
 * <p>
 * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100. Did you notice that the reversed integer might overflow?
 * Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
 * 
 * Throw an exception? Good, but what if throwing an exception is not an option? You would then have to re-design the function (ie, add an extra
 * parameter).
 * </p>
 * 
 * @author kent
 * 
 */
public class ReverseInteger extends Problem<Integer, Integer> {

	@Override
	public String getBigO() {
		return "O(n)";
	}

	@Override
	public Integer solve(final Integer data) {
		int a = data;
		final boolean negative = a < 0;
		a = negative ? -a : a;
		int p = (int) Math.log10(a);
		if (p == 0) {
			return negative ? -a : a;
		}
		int result = 0;
		while (p >= 0) {
			result += a % 10 * (int) Math.pow(10, p);
			a /= 10;
			p--;
		}
		return negative ? -result : result;
	}
}
