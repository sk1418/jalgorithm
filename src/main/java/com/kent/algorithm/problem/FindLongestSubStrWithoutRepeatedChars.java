package com.kent.algorithm.problem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.kent.algorithm.Problem;
import com.kent.util.AlgUtil;

/**
 * From http://oj.leetcode.com/problems/longest-substring-without-repeating-characters/
 * <p>
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 * For "bbbbb" the longest substring is "b", with the length of 1.
 * </p>
 *
 * <p>
 *     <b>Solution:</b>
 *
 *
 *
 * </p>
 * @author kent
 * 
 */
public class FindLongestSubStrWithoutRepeatedChars extends Problem<String, Integer> {

	@Override
	public String getBigO() {
		return "O(n)";
	}

	@Override
	public Integer solve(final String data) {
		assert data!=null;
		Set<Character> table = new HashSet<>();
		char[] chars = data.toCharArray();
		int i=0, j=0; // i is the start chk idx, j is end
		int maxLen = 0;

		for (; j < data.length(); j++) {
			if (table.contains(chars[j])) {
				maxLen = Math.max(maxLen, j - i);
				while (chars[i] != chars[j]) {
					table.remove(chars[i]);
					i++;
				}
				i++;
			}
			else {
				table.add(chars[j]);
			}
		}

		// compare the rest segment with maxLen
		maxLen = Math.max(maxLen, j - i);

		return maxLen;
	}


}
