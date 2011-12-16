package com.kent.algorithm.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.kent.algorithm.demo.problem.CountInversionPairsDemo;
import com.kent.algorithm.demo.problem.FindHeavyIntegerDemo;
import com.kent.algorithm.demo.problem.MaxSubArrayDemo;
import com.kent.algorithm.demo.sorting.BubbleSortDemo;
import com.kent.algorithm.demo.sorting.InsertionSortDemo;
import com.kent.algorithm.demo.sorting.MergeSortDemo;
import com.kent.algorithm.demo.sorting.SortingComparasionDemo;
import com.kent.util.AlgUtil;

public class Demo {

	private static Map<Integer, Class> demoTypeMap = new HashMap<Integer, Class>();

	enum DemoType {
		// @formatter:off
		Sorting(1, SortingComparasionDemo.class), 
		InsertionSort(2, InsertionSortDemo.class), 
		BubbleSort(3, BubbleSortDemo.class), 
		MergeSort(4, MergeSortDemo.class), 
		Problem_MaxSubArray(8, MaxSubArrayDemo.class), 
		Problem_CountInversionPairs(9, CountInversionPairsDemo.class),
		Problem_FindHeavyIntegers(10, FindHeavyIntegerDemo.class);
		// @formatter:on
		private final int idx;
		private final Class<? extends AbstractDemo> demoClass;

		DemoType(int idx, Class<? extends AbstractDemo> demoClass) {
			this.idx = idx;
			this.demoClass = demoClass;
		}

		public int getIdx() {
			return idx;
		}

		public Class<? extends AbstractDemo> getDemoClass() {
			return demoClass;
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner;
		int input = -1;
		String tmp;
		final boolean init = true;
		scanner = new Scanner(System.in);
		while (input != 0) {
			try {

				AlgUtil.print(AlgUtil.repeatString("\n", 3));
				AlgUtil.print("Available Demos:");
				AlgUtil.print(AlgUtil.repeatString("=", 70));
				AlgUtil.print(getDemoTypePrintList());
				AlgUtil.print(AlgUtil.repeatString("=", 70));
				if (!demoTypeMap.containsKey(input)) {
					AlgUtil.print("unknow demo index, please input a valid demo index (0 to exit):");
				} else {
					AlgUtil.print("select the demo index (press 0 to exit):");
				}
				tmp = scanner.nextLine();
				input = Integer.valueOf(tmp);
				if (input == 0) {
					break;
				}
				if (demoTypeMap.containsKey(input)) {
					final AbstractDemo demo = (AbstractDemo) demoTypeMap.get(input).newInstance();
					AlgUtil.print(AlgUtil.repeatString("\n", 2));
					AlgUtil.clear();
					AlgUtil.print("[ " + demoTypeMap.get(input).getSimpleName() + " ]\n");
					demo.doDemo();
				}
			} catch (final Exception e) {
				input = -1;
			}
		}

		AlgUtil.print("exiting...");
		System.exit(0);
	}

	private static String getDemoTypePrintList() {
		demoTypeMap.clear();
		final String format = "%-30s %s %s";
		final StringBuffer sb = new StringBuffer();
		int i = 0;
		for (final DemoType type : DemoType.values()) {
			i++;
			sb.append(String.format(format, type, AlgUtil.repeatString(".", 30), type.getIdx()));
			sb.append(i == DemoType.values().length ? "" : "\n");
			demoTypeMap.put(type.getIdx(), type.getDemoClass());
		}
		return sb.toString();
	}
}
