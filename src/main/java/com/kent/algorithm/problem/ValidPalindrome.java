package com.kent.algorithm.problem;

import com.kent.algorithm.Problem;

/**
 * From: https://oj.leetcode.com/problems/valid-palindrome/
 * <p/>
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p/>
 * For example,
 * <pre>
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * </pre>
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 *
 * For the purpose of this problem, we define empty string as valid palindrome.
 *
 * @author: Kent
 * Created on 2014-06-03.
 */
public class ValidPalindrome extends Problem<String, Boolean> {

	@Override
	public Boolean solve(String data) {
		data = data.toLowerCase().replaceAll("[^a-z0-9]","");
		int len = data.length();
		if (len == 0) {
			return true;
		}
		for (int i = 0; i <= len / 2 - 1; i++) {
			if (data.charAt(len - i - 1) != data.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String getBigO() {
		return "O(n)";
	}
}
