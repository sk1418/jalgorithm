package com.kent.algorithm.problem;

import java.util.Stack;

import com.kent.algorithm.Problem;

/**
 * from leetcode:https://oj.leetcode.com/problems/reverse-words-in-a-string/
 *
 * <pre>
 * Given an input string, reverse the string word by word.
 *
 * For example,
 * 
 * Given s = "the sky is blue",
 * return "blue is sky the".
 *<br/>
 * #Clarification:
 * What constitutes a word?
 * - A sequence of non-space characters constitutes a word.
 *
 * - Could the input string contain leading or trailing spaces?
 * > Yes. However, your reversed string should not contain leading or trailing spaces.
 * 
 * - How about multiple spaces between two words?
 * > Reduce them to a single space in the reversed string.
 *</pre>
 *
 * <b>Solution</b>:
 * <pre>
 *    - trim and split the string
 *    - push each element into a stack
 *    - pop word from stack and concatenate spaces
 *
 * </pre>
 * @author: Kent
 * Created on 2014-08-10.
 */
public class ReverseWordsInString extends Problem<String, String> {

	@Override
	public String solve(String data) {
		if (data == null) {
			return null;
		}
		data = data.trim();
		String re = "\\s+";
		String[] words = data.split(re);
		if (words.length == 0) {
			return data;
		}
		//till here special cases were checked
		StringBuilder resultSB = new StringBuilder();
		Stack<String> stack = new Stack();
		for (String w : words) {
			stack.push(w);
		}
		while (!stack.isEmpty()) {
			resultSB.append(stack.pop());
			if(!stack.isEmpty())
				resultSB.append(" ");
		}
		return resultSB.toString();
	}

	@Override
	public String getBigO() {
		return "Time: O(n); Space: O(n)";
	}
}
