package com.kent.algorithm.problem;

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
		String result = "";
		for (int i = words.length - 1;i>=0; i--) {
			if(i<words.length -1)
				result += " ";
			result += words[i];
		}
		return result;
	}

	@Override
	public String getBigO() {
		return "Time: O(n); Space: O(n)";
	}
}
