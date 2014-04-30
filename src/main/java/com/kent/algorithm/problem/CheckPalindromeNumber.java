package com.kent.algorithm.problem;

import com.kent.algorithm.Problem;
import com.kent.util.AlgUtil;

/**
 *
 * From http://oj.leetcode.com/problems/palindrome-number
 * <p>
 *     Determine whether an integer is a palindrome. Do this <b>without extra space.</b>
 * </p>
 *
 * <p>The requirement is space O(1), so we cannot convert number into String. </p>
 * <b>Solution</b>
 * <p>
 *     return false if Negative number.
 *     check the first and last number, if they are same, if yes, chop them, then check again until the number ==0
 * </p>
 *
 * @author kent
 * Created on 2014-04-30.
 */
public class CheckPalindromeNumber extends Problem<Integer, Boolean> {
	@Override
	public Boolean solve(Integer data) {
		assert data!=null;
		if (data < 0) return false;
		//get the divider i.e. data=76543, get 10000
		int div = (int) Math.pow(10, (int)Math.log10(data));

		while (data != 0) {
			int h = data / div; //head
			int t = data % 10; //tail
			if (h!=t) return false;
			//now chop the head and tail
			data = (data % div)/10;

			if (printSteps()) {
				AlgUtil.println("After chopping: " + String.valueOf(data));
			}
			div /= 100;
		}
		return true;
	}

	@Override
	public String getBigO() {
		return "Space:O(1)";
	}
}
