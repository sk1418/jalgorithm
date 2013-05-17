package com.kent.algorithm.demo.problem;

import java.util.ArrayList;
import java.util.Arrays;

import com.google.common.base.Joiner;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.FindAllSubSets;
import com.kent.util.AlgUtil;

public class FindAllSubSetsDemo extends AbstractDemo {

	private int[] input1;

	private int[] input2;

	private FindAllSubSets problem;

	@Override
	protected void warmingUp() { // warming up is not required
	}

	@Override
	protected void prepareDemo() {
		input1 = new int[] { 1, 2, 3 };
		input2 = new int[] { -10, 0, 10, 20, 50 };
		problem = new FindAllSubSets();
	}

	@Override
	protected void specificDemo() {
		print(String.format("Time Complexity: %s\n", problem.getBigO()));
		doJob(input1);
		doJob(input2);
	}

	private void doJob(final int[] input) {
		print("\nArray: " + Arrays.toString(input));
		print("All subsets:\n");
		final ArrayList<ArrayList<Integer>> result = problem.solve(input);
		final String s;
		int i = 1;
		for (final ArrayList<Integer> l : result) {

			AlgUtil.print("[" + Joiner.on(", ").join(l) + "] ");
			if (i % 8 == 0) {
				print("");
			}
			i++;
		}

		print("\n-=-=-=-=-=-=-");
	}

	@Override
	protected void printDescription() {
		//@formatter:off
		final String d =Joiner.on("\n").join(
				" Given a set of distinct integers, S, return all possible subsets. ",
				"  ",
				" Note: ",
				"  ",
				" Elements in a subset must be in non-descending order. The solution set must not contain duplicate subsets. ",
				"  ",
				" For example, If S = [1,2,3], a solution is: ",
				"  ",
				"  ",
				" [ ",
				" [3],  [1],  [2],  [1,2,3], [1,3], [2,3], [1,2], [] ",
				" ] ",
				"  ",
				"  ",
				" <Algorithm> ",
				" - sort the array (this is just for the requirement \"Elements in a subset must be in non-descending order\") ",
				" - iterate each element to calculate the subset ",
				" - in each iteration, the step result = ",
				"  ",
				"  ",
				"  ",
				"  elements in last iteration +  ",
				"  (each element from last iteration + current array element) + ",
				"  current array element ",
				"  ",
				" for example [1,2,3] ",
				"  ",
				" 1st iteration: [1] ",
				" 2nd iteration: [1],[1,2],[2] ",
				" 3rd iteration: [1],[1,2],[2],[1,3],[1,2,3],[2,3],[3] "
		);
		//@formatter:on

		print(d);
	}
}
