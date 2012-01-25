package com.kent.algorithm.problem;

import java.util.Arrays;

import com.kent.algorithm.Problem;
import com.kent.util.AlgUtil;

/**
 * <p>
 * You are given an array of strings, where different strings may have different numbers of characters, but the total number of characters over all
 * the strings is n. Show how to sort the strings in O(n) time. (Note that the desired order here is the standard alphabetical order; for example, a <
 * ab < b.)
 * 
 * 
 * </p>
 * 
 * <p>
 * To solve the problem in O(n) time, we use the property that, if the first letter of string x is lexicographically less that the first letter of
 * string y, then x is lexicographically less than y, regardless of the lengths of the two strings. We take advantage of this property by sorting the
 * strings on the first letter, using counting sort. We take an empty string as a special case and put it first. We gather together all strings with
 * the same first letter as a group. Then we recurse, within each group, based on each string with the first letter removed.
 * </p>
 * 
 * @author kent
 * 
 */
public class SortingStringsWithTotalNChars extends Problem<String[], String[]> {

	// a copy of original String array
	private String[] strings;
	// result stores the indexes of sorted String
	private int[] result = new int[0];

	@Override
	public String getBigO() {
		return "O(n) [n is total number of characters]";
	}

	@Override
	public String[] solve(String[] data) {
		final String[] sorted = new String[data.length];
		strings = Arrays.copyOfRange(data, 0, data.length);
		final int[] indexes = new int[data.length];
		for (int i = 0; i < indexes.length; i++) {
			indexes[i] = i;
		}
		grouping(indexes);
		for (int i = 0; i < result.length; i++) {
			sorted[i] = data[result[i]];
		}
		return sorted;
	}

	/**
	 * group the passed in Strings (array indexes), and append indexes to result array
	 * 
	 * @param indexes
	 *            , the indexes of String array.
	 */
	private void grouping(int[] indexes) {

		final int[][] groups = new int[128][0];
		for (int i = 0; i < indexes.length; i++) {
			final int charV = getFirstChar(strings[indexes[i]]); // get the first char ascii
			strings[indexes[i]] = charV > 0 ? strings[indexes[i]].substring(1) : strings[indexes[i]]; // remove the first letter
			groups[charV] = AlgUtil.appendIntArray(groups[charV], indexes[i]); // grouping strings (using index) by first char
		}
		// add element index if ascii=0
		for (int o = 0; o < groups[0].length; o++) {
			result = AlgUtil.appendIntArray(result, groups[0][o]);
		}
		for (int i = 1; i < groups.length; i++) {
			if (groups[i].length > 0) {
				if (groups[i].length == 1) {
					// add element to result if there it is only element in certain group
					result = AlgUtil.appendIntArray(result, groups[i][0]);
				} else {
					// recursively call grouping method for each group
					grouping(groups[i]);
				}
			}
		}

	}

	private int getFirstChar(String s) {
		final char[] chars = s.toCharArray();
		return chars.length > 0 ? chars[0] : 0;
	}

}
