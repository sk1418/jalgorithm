package com.kent.algorithm.problem;

import static com.kent.util.AlgUtil.println;
import static com.kent.util.AlgUtil.swap;

import com.kent.algorithm.Problem;
import com.kent.util.AlgUtil;

/**
 * <p>
 * Given a number, find the next higher number which has the exact same set of digits as the original number. For example: given 38276 return 38627
 * </p>
 * 
 * 
 * <p>
 * <b>algorithm</b><br/>
 * <ul>
 * <li>Starting from the right, you find the first pair-of-digits such that the left-digit is smaller than the right-digit.</li>
 * <li>Let's refer to the left-digit by "digit-x". Find the smallest number larger than digit-x to the right of digit-x, and place it immediately left
 * of digit-x.</li>
 * <li>Finally, sort the remaining digits in ascending order - since they were already in descending order, all you need to do is reverse them</li>
 * </ul>
 * (save for digit-x, which can be placed in the correct place in O(n)).
 * </p>
 * 
 * <pre>
 * 
 * 23456784987654321
 * start with a number
 * 
 * 123456784 987654321
 *          ^the first place where the left-digit is less-than the right-digit is here.  Digit "x" is 4
 * 
 * 123456784 987654321
 *               ^find the smallest digit larger than 4 to the right
 * 
 * 123456785 987644321
 *               ^ swap it with x
 * 
 * 123456785 123446789
 * 123456785123446789
 *          ^sort the digits to the right of 5.  Since all of them were already in descending order, all we need to do is reverse their order
 * 
 * </pre>
 * 
 * @author kent
 * 
 */
public class FindNextHigherNumber extends Problem<Long, Long> {

	@Override
	public String getBigO() {
		return "O(n)";
	}

	@Override
	public Long solve(Long data) {
		final char[] c = data.toString().toCharArray();

		int max = c.length - 1; // max index
		int x = 0;
		for (int i = c.length - 1; i >= 0; i--) {
			if (c[i] < c[max]) {
				x = i;
				break;
			} else {
				max = i;
			}
		}
		// print demo info
		if (printSteps()) {
			String s = "";
			for (int i = 0; i < c.length; i++) {
				s += i == x ? "(" + c[i] + ")" : c[i];
			}
			println("Found the 'x' :" + s);
		}
		// find the smallest digit, that greater than c[x]
		int y = c.length - 1;
		for (int i = c.length - 1; i > x; i--) {
			if (c[i] > c[x]) {
				y = i;
				break;
			}
		}

		// print step info for demo
		if (printSteps()) {
			String s = "";
			for (int i = 0; i < c.length; i++) {
				s += i == x || i == y ? "(" + c[i] + ")" : c[i];
			}
			println("Found the smallest digit, that greater than x :" + s);
		}
		// swap
		swap(c, x, y);

		reverseArray(c, x + 1, c.length - 1);
		final Long l = Long.valueOf(String.valueOf(c));
		return l;
	}

	private void reverseArray(char[] input, int start, int end) {
		if (end - start <= 0) {
			return;
		}
		for (int i = start; i < start + (end - start + 1) / 2 + 1; i++) {
			if (end - i + start <= i) {
				return;
			}
			AlgUtil.swap(input, i, end - i + start);
		}
	}

}
