package com.kent.algorithm.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.kent.algorithm.demo.problem.CountInversionPairsDemo;
import com.kent.algorithm.demo.problem.FindHeavyIntegerDemo;
import com.kent.algorithm.demo.problem.FindNextHigherNumberDemo;
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
import com.kent.algorithm.demo.sorting.RadixSortDemo;
import com.kent.algorithm.demo.sorting.RandomizedQuickSortDemo;
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
		RandomizedQuickSort(8 , RandomizedQuickSortDemo.class), 
		//sorting in linear time
		CountingSort(11, CountingSortDemo.class), 
		BucketSort(12, BucketSortDemo.class), 
		RadixSort(13, RadixSortDemo.class), 
		//problems
		Problem_MaxSubArray(100, MaxSubArrayDemo.class), 
		Problem_CountInversionPairs(101, CountInversionPairsDemo.class),
		Problem_FindHeavyIntegers(102, FindHeavyIntegerDemo.class),
		Problem_SortingIntegerWithNDigits(103, SortingIntegersWithNDigitsDemo.class),
		Problem_SortingStringsWithNChars(104, SortingStringsWithNCharsDemo.class),
		Problem_FindNextHigherNumber(105, FindNextHigherNumberDemo.class);
		
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
	public static void main(final String[] args) {
		Scanner scanner;
		int input = -9;
		String tmp;
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
		scanner.close();
		System.exit(0);
	}

	private static String getDemoTypePrintList() {
		demoTypeMap.clear();
		final String format = "%4s %s %-30s";
		final StringBuffer sb = new StringBuffer();
		int i = 0, idx = 0;
		for (final DemoType type : DemoType.values()) {
			i++;
			idx = type.getIdx();
			if (idx == 1) {
				sb.append("\n-- Sortings --\n\n");
			} else if (idx == 11) {
				sb.append("\n-- Sorting in linear time --\n\n");
			} else if (idx == 100) {
				sb.append("\n-- Problems --\n\n");
			}
			sb.append(String.format(format, type.getIdx(), AlgUtil.repeatString(".", 7), type));
			sb.append(i == DemoType.values().length ? "" : "\n");
			demoTypeMap.put(type.getIdx(), type.getDemoClass());
		}
		return sb.toString();
	}
}
