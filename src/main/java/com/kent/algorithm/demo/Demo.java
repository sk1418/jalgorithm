package com.kent.algorithm.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.kent.algorithm.demo.problem.AddTwoNumbersDemo;
import com.kent.algorithm.demo.problem.CountInversionPairsDemo;
import com.kent.algorithm.demo.problem.FindAllSubSetsDemo;
import com.kent.algorithm.demo.problem.FindHeavyIntegerDemo;
import com.kent.algorithm.demo.problem.FindNextHigherNumberDemo;
import com.kent.algorithm.demo.problem.MaxSubArrayDemo;
import com.kent.algorithm.demo.problem.MedianOfTwoSortedArraysDemo;
import com.kent.algorithm.demo.problem.PlusOneDemo;
import com.kent.algorithm.demo.problem.RemoveAllNodesHaveDupsFromSortedLinkedListDemo;
import com.kent.algorithm.demo.problem.RemoveDupsFromSortedArrayDemo;
import com.kent.algorithm.demo.problem.RemoveDupsFromSortedLinkedListDemo;
import com.kent.algorithm.demo.problem.RemoveNthNodeFromEndOfLinkedListDemo;
import com.kent.algorithm.demo.problem.ReverseIntegerDemo;
import com.kent.algorithm.demo.problem.ReverseLinkedListDemo;
import com.kent.algorithm.demo.problem.ReverseLinkedListEveryKNodesDemo;
import com.kent.algorithm.demo.problem.RotateListDemo;
import com.kent.algorithm.demo.problem.SortingIntegersWithNDigitsDemo;
import com.kent.algorithm.demo.problem.SortingStringsWithNCharsDemo;
import com.kent.algorithm.demo.problem.SwapListNodesInPairsDemo;
import com.kent.algorithm.demo.problem.TwoSumInArrayDemo;
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
		CompSort, LinearSort, Problems, ListProblem
	}

	enum DemoItem {
		// @formatter:off
		
		//sortings
		SortingComparasion(1,DemoType.CompSort, SortingComparasionDemo.class), 
		InsertionSort(2,DemoType.CompSort, InsertionSortDemo.class), 
		BubbleSort(3,DemoType.CompSort, BubbleSortDemo.class), 
		MergeSort(4,DemoType.CompSort, MergeSortDemo.class), 
		MergeSort_Optimized(5,DemoType.CompSort, OptimizedMergeSortDemo.class),   
		HeapSort(6,DemoType.CompSort, HeapSortDemo.class), 
		QuickSort(7 ,DemoType.CompSort, QuickSortDemo.class), 
		RandomizedQuickSort(8 ,DemoType.CompSort, RandomizedQuickSortDemo.class), 

		//sorting in linear time
		CountingSort(11, DemoType.LinearSort, CountingSortDemo.class), 
		BucketSort(12, DemoType.LinearSort, BucketSortDemo.class), 
		RadixSort(13, DemoType.LinearSort, RadixSortDemo.class), 
		//problems
		MaxSubArray(100, DemoType.Problems, MaxSubArrayDemo.class), 
		CountInversionPairs(101, DemoType.Problems, CountInversionPairsDemo.class),
		FindHeavyIntegers(102, DemoType.Problems, FindHeavyIntegerDemo.class),
		SortingIntegerWithNDigits(103, DemoType.Problems, SortingIntegersWithNDigitsDemo.class),
		SortingStringsWithNChars(104, DemoType.Problems, SortingStringsWithNCharsDemo.class),
		FindNextHigherNumber(105, DemoType.Problems, FindNextHigherNumberDemo.class),
		TwoSumInArray(106, DemoType.Problems, TwoSumInArrayDemo.class),
		PlusOne(107, DemoType.Problems, PlusOneDemo.class),
		ReverseInteger(108, DemoType.Problems, ReverseIntegerDemo.class),
		MedianOfTwoSortedArrays(109, DemoType.Problems, MedianOfTwoSortedArraysDemo.class),
		FindAllSubSets(110, DemoType.Problems, FindAllSubSetsDemo.class),
		AddTwoNumbers(111, DemoType.Problems, AddTwoNumbersDemo.class),
		ReverseLinkedList(112, DemoType.Problems, ReverseLinkedListDemo.class),
		RotateList(113, DemoType.Problems, RotateListDemo.class),
		SwapListNodesInPairs(114, DemoType.Problems, SwapListNodesInPairsDemo.class),
		ReverseLinkedListEveryKNodes(115, DemoType.Problems, ReverseLinkedListEveryKNodesDemo.class),
		RemoveDupsFromSortedLinkedList(116, DemoType.Problems, RemoveDupsFromSortedLinkedListDemo.class),
		RemoveAllNodesHaveDupsFromSortedLinkedListDemo(117, DemoType.Problems, RemoveAllNodesHaveDupsFromSortedLinkedListDemo.class),
		RemoveNthNodeFromEndOfLinkedList(118, DemoType.Problems, RemoveNthNodeFromEndOfLinkedListDemo.class),
		RemoveDupsFromSortedArray(119, DemoType.Problems, RemoveDupsFromSortedArrayDemo.class);


		// @formatter:on
		private final int idx;
		private final Class<? extends AbstractDemo> demoClass;
		private final DemoType type;

		DemoItem(final int idx, final DemoType type, final Class<? extends AbstractDemo> demoClass) {
			this.idx = idx;
			this.demoClass = demoClass;
			this.type = type;
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
					AlgUtil.println("\n" + AlgUtil.repeatString("=", 49));
					AlgUtil.println("Press [Enter] to continue... ");
					tmp = scanner.nextLine();
					input = -9;
				}
			} catch (final Exception e) {
				e.printStackTrace();
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
		for (final DemoItem item : DemoItem.values()) {
			i++;
			idx = item.getIdx();
			if (idx == 1) {
				sb.append("\n-- Sortings --\n\n");
			} else if (idx == 11) {
				sb.append("\n-- Sorting in linear time --\n\n");
			} else if (idx == 100) {
				sb.append("\n-- Problems --(from StackOverflow.com, leetcode.com ...)\n\n");
			}
			sb.append(String.format(format, item.getIdx(), AlgUtil.repeatString(".", 7), item));
			sb.append(i == DemoItem.values().length ? "" : "\n");
			demoTypeMap.put(item.getIdx(), item.getDemoClass());
		}
		return sb.toString();
	}
}
