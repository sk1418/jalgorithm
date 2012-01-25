package com.kent.algorithm.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.kent.algorithm.demo.problem.CountInversionPairsDemo;
import com.kent.algorithm.demo.problem.FindHeavyIntegerDemo;
import com.kent.algorithm.demo.problem.MaxSubArrayDemo;
import com.kent.algorithm.demo.problem.SortingIntegersWithNDigitsDemo;
import com.kent.algorithm.demo.problem.SortingStringsWithNCharsDemo;
import com.kent.algorithm.demo.sorting.BubbleSortDemo;
import com.kent.algorithm.demo.sorting.BucketSortDemo;
import com.kent.algorithm.demo.sorting.CountingSortDemo;
import com.kent.algorithm.demo.sorting.HeapSortDemo;
import com.kent.algorithm.demo.sorting.InsertionSortDemo;
import com.kent.algorithm.demo.sorting.MergeSortDemo;
import com.kent.algorithm.demo.sorting.OptimizedMergeSortDemo;
import com.kent.algorithm.demo.sorting.QuickSortDemo;
import com.kent.algorithm.demo.sorting.SortingComparasionDemo;
import com.kent.util.AlgUtil;

public class Demo {

	private static Map<Integer, Class<? extends AbstractDemo>> demoTypeMap = new HashMap<Integer, Class<? extends AbstractDemo>>();

	enum DemoType {
		// @formatter:off
		
		//sortings
		SortingComparasion(1, SortingComparasionDemo.class), 
		InsertionSort(2, InsertionSortDemo.class), 
		BubbleSort(3, BubbleSortDemo.class), 
		MergeSort(4, MergeSortDemo.class), 
		MergeSort_Optimized(5, OptimizedMergeSortDemo.class),   
		HeapSort(6, HeapSortDemo.class), 
		QuickSort(7 , QuickSortDemo.class), 
		CountingSort(8, CountingSortDemo.class), 
		BucketSort(9, BucketSortDemo.class), 
		//problems
		Problem_MaxSubArray(10, MaxSubArrayDemo.class), 
		Problem_CountInversionPairs(11, CountInversionPairsDemo.class),
		Problem_FindHeavyIntegers(12, FindHeavyIntegerDemo.class),
		Problem_SortingIntegerWithNDigits(13, SortingIntegersWithNDigitsDemo.class),
		Problem_SortingStringsWithNChars(14, SortingStringsWithNCharsDemo.class);
		
		// @formatter:on
		private final int idx;
		private final Class<? extends AbstractDemo> demoClass;

		DemoType(final int idx, final Class<? extends AbstractDemo> demoClass) {
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
		int input = -9;
		String tmp;
		final boolean init = true;
		scanner = new Scanner(System.in);

		while (input != 0) {
			try {

				AlgUtil.println(AlgUtil.repeatString("\n", 3));
				AlgUtil.println("Available Demos:");
				AlgUtil.println(AlgUtil.repeatString("=", 49));
				AlgUtil.println(getDemoTypePrintList());
				AlgUtil.println(AlgUtil.repeatString("=", 49));
				if (input == -9) {

					AlgUtil.println("select the demo index (press 0 to exit):");
				} else if (!demoTypeMap.containsKey(input)) {
					AlgUtil.println("unknow demo index, please input a valid demo index (0 to exit):");
				}
				tmp = scanner.nextLine();
				input = Integer.valueOf(tmp);
				if (input == 0) {
					break;
				}
				if (demoTypeMap.containsKey(input)) {
					final AbstractDemo demo = demoTypeMap.get(input).newInstance();
					AlgUtil.println(AlgUtil.repeatString("\n", 2));
					AlgUtil.clear();
					AlgUtil.println("[ " + demoTypeMap.get(input).getSimpleName() + " ]\n");
					demo.doDemo();
					input = -9;
				}
			} catch (final Exception e) {
				input = -1;
			}
		}

		AlgUtil.println("exiting...");
		System.exit(0);
	}

	private static String getDemoTypePrintList() {
		demoTypeMap.clear();
		final String format = "%3s %s %-30s";
		final StringBuffer sb = new StringBuffer();
		int i = 0;
		for (final DemoType type : DemoType.values()) {
			i++;
			sb.append(String.format(format, type.getIdx(), AlgUtil.repeatString(".", 7), type));
			sb.append(i == DemoType.values().length ? "" : "\n");
			demoTypeMap.put(type.getIdx(), type.getDemoClass());
		}
		return sb.toString();
	}
}
