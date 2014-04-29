package com.kent.algorithm.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.Lists;
import com.kent.algorithm.demo.problem.AddTwoNumbersDemo;
import com.kent.algorithm.demo.problem.CountInversionPairsDemo;
import com.kent.algorithm.demo.problem.FindAllSubSetsDemo;
import com.kent.algorithm.demo.problem.FindHeavyIntegerDemo;
import com.kent.algorithm.demo.problem.FindLongestSubStrWithoutRepeatedCharsDemo;
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

	// @formatter:off
	//menu layout, define the left/right block.
	private static final ImmutableListMultimap<Integer, DemoType> MENU_LAYOUT = ImmutableListMultimap.<Integer, DemoType>builder()
			.putAll(1, DemoType.CompSort, DemoType.LinearSort)
			.putAll(2, DemoType.Test)
			.putAll(3, DemoType.Problems)
			.build();
	

	enum DemoType {
		CompSort("Comparison Sort"), 
		LinearSort("Sorting in linear time"),
		Problems("Problems (from StackOverflow.com, leetcode.com ...)"), 
		Test("This is a test separator/marker"); 
//		ListProblem("blah");

		private final String desc;

		DemoType(final String text) {
			desc = text;
		}

	}

	enum DemoItem{
		
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
		RemoveAllNodesHaveDupsFromSortedLinkedList(117, DemoType.Problems, RemoveAllNodesHaveDupsFromSortedLinkedListDemo.class),
		RemoveNthNodeFromEndOfLinkedList(118, DemoType.Problems, RemoveNthNodeFromEndOfLinkedListDemo.class),
		RemoveDupsFromSortedArray(119, DemoType.Problems, RemoveDupsFromSortedArrayDemo.class),
		FindLongestSubStrWithoutRepeatedChars(120, DemoType.Problems, FindLongestSubStrWithoutRepeatedCharsDemo.class);




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

		public static List<DemoItem> getItemsByDemoType(final DemoType type) {
			return Lists.newArrayList(Collections2.filter(Arrays.asList(values()), new Predicate<DemoItem>() {
				@Override
				public boolean apply(final DemoItem input) {
					return input.type == type;
				}
			}));
		}

		public static Map<Integer, Class<? extends AbstractDemo>> getMenuDemoMap() {
			// mapping the menu idx to demo class
			final Map<Integer, Class<? extends AbstractDemo>> map = new HashMap<Integer, Class<? extends AbstractDemo>>();

			for (final DemoItem item : DemoItem.values()) {
				map.put(item.getIdx(), item.getDemoClass());
			}
			return map;
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
		final Map<Integer, Class<? extends AbstractDemo>> menuDemoMap = DemoItem.getMenuDemoMap();

		// init

		while (input != 0) {
			try {

				AlgUtil.println(AlgUtil.repeatString("\n", 3));
				AlgUtil.println("Available Demos:");
				// AlgUtil.println(getDemoTypePrintList());
				printMenu();
				AlgUtil.println(AlgUtil.repeatString("=", 77));
				if (input == -9) {

					AlgUtil.println("select the demo index (press 0 to exit):");
				} else if (!menuDemoMap.containsKey(input)) {
					AlgUtil.println("unknow demo index, please input a valid demo index (0 to exit):");
				}
				tmp = scanner.nextLine();
				input = Integer.valueOf(tmp);
				if (input == 0) {
					break;
				}
				if (menuDemoMap.containsKey(input)) {
					final AbstractDemo demo = DemoItem.getMenuDemoMap().get(input).newInstance();
					AlgUtil.println(AlgUtil.repeatString("\n", 2));
					AlgUtil.clear();
					AlgUtil.println("[ " + menuDemoMap.get(input).getSimpleName() + " ]\n");
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

	// the line format of two columns layout
	private static final String FORMAT = "%4s %-35s |%4s %-35s";

	private static void printMenu() {
		final int rows = MENU_LAYOUT.keySet().size();
		final DemoType type = null;
		for (int row = 1; row <= rows; row++) {
			AlgUtil.println("\n" + AlgUtil.repeatString("=", 77));
			if (MENU_LAYOUT.get(row).size() == 1) {
				printSingleColMenu(MENU_LAYOUT.get(row).get(0));
			} else {
				printDoubleColMenu(MENU_LAYOUT.get(row));
			}
		}
	}

	private static void printSingleColMenu(final DemoType type) {
		final List<DemoItem> items = DemoItem.getItemsByDemoType(type);
		AlgUtil.println(type.desc);

		final int size = items.size();
		// if it is just a marker/separator, return
		if (size == 0) {
			return;
		}
		AlgUtil.println(AlgUtil.repeatString("_", 77));
		final int rows = size % 2 == 0 ? size / 2 : size / 2 + 1;
		DemoItem iteml = null;
		DemoItem itemr = null;
		for (int i = 0; i < rows; i++) {
			iteml = items.get(i);
			itemr = i + rows < size ? items.get(i + rows) : null;
			if (itemr != null) {
				AlgUtil.println(String.format(FORMAT, iteml.idx, iteml, itemr.idx, itemr));
			} else {
				AlgUtil.println(String.format(FORMAT, iteml.idx, iteml, "", ""));
			}
		}

	}

	private static void printDoubleColMenu(final List<DemoType> type) {
		assert type.size() == 2;
		final List<DemoItem> itemsl = DemoItem.getItemsByDemoType(type.get(0));
		final List<DemoItem> itemsr = DemoItem.getItemsByDemoType(type.get(1));
		final int rows = itemsl.size() > itemsr.size() ? itemsl.size() : itemsr.size();
		DemoItem iteml = null;
		DemoItem itemr = null;

		AlgUtil.println(String.format("%-40s |%-40s", type.get(0).desc, type.get(1).desc));
		AlgUtil.println(AlgUtil.repeatString("_", 77));
		for (int i = 0; i < rows; i++) {
			itemr = i < itemsr.size() ? itemsr.get(i) : null;
			iteml = i < itemsl.size() ? itemsl.get(i) : null;
			if (iteml == null) {
				AlgUtil.println(String.format(FORMAT, "", "", itemr.idx, itemr));
			} else if (itemr == null) {
				AlgUtil.println(String.format(FORMAT, iteml.idx, iteml, "", ""));
			} else {
				AlgUtil.println(String.format(FORMAT, iteml.idx, iteml, itemr.idx, itemr));
			}

		}

	}
}
