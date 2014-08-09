package com.kent.algorithm.problem;

import java.util.Stack;

import com.kent.algorithm.Problem;

/**
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
