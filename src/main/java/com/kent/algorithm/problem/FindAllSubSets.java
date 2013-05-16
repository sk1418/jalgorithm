package com.kent.algorithm.problem;

import java.util.ArrayList;
import java.util.Arrays;

import com.kent.algorithm.Problem;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 * <p>
 * Note:
 * 
 * Elements in a subset must be in non-descending order. The solution set must not contain duplicate subsets.
 * 
 * For example, If S = [1,2,3], a solution is:
 * </p>
 * 
 * <pre>
 * [
 * [3],  [1],  [2],  [1,2,3], [1,3], [2,3], [1,2], []
 * ]
 * </pre>
 * 
 * <b>algorithm</b>
 * <p>
 * <ul>
 * <li/>sort the array (this is just for the requirement "Elements in a subset must be in non-descending order")
 * <li/>iterate each element to calculate the subset
 * <li/>in each iteration, the step result =
 * </ul>
 * 
 * <pre>
 *  elements in last iteration + 
 *  (each element from last iteration + current array element) +
 * current array element
 * 
 * for example [1,2,3]
 * 
 * 1st iteration: [1]
 * 2nd iteration: [1],[1,2],[2]
 * 3rd iteration: [1],[1,2],[2],[1,3],[1,2,3],[2,3],[3]
 * 
 * </pre>
 * 
 * </p>
 * 
 * @author kent
 * 
 */
public class FindAllSubSets extends Problem<int[], ArrayList<ArrayList<Integer>>> {

	@Override
	public String getBigO() {
		return "O(2^n)";
	}

	@Override
	public ArrayList<ArrayList<Integer>> solve(final int[] data) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(data);
		for (final int e : data) {
			result = findSubSets(e, result);
		}

		result.add(new ArrayList<Integer>());
		return result;

	}

	private ArrayList<ArrayList<Integer>> findSubSets(final int e, final ArrayList<ArrayList<Integer>> result) {
		ArrayList<Integer> l = null;
		final ArrayList<ArrayList<Integer>> tmpList = new ArrayList<ArrayList<Integer>>();
		if (result.size() > 0) {

			for (final ArrayList<Integer> last : result) {
				l = new ArrayList<Integer>(last);
				l.add(e);
				tmpList.add(l);
			}
		}
		l = new ArrayList<Integer>();
		l.add(e);
		tmpList.add(l);
		result.addAll(tmpList);
		return result;

	}
}
