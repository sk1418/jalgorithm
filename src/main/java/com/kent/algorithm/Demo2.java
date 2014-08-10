package com.kent.algorithm;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.omg.PortableInterceptor.DISCARDING;
import org.reflections.Reflections;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Maps;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoItem;
import com.kent.algorithm.ui.DemoType;
import com.kent.algorithm.ui.UiHelper;
import com.kent.util.AlgUtil;

public class Demo2 {

	// @formatter:off
	//menu layout, define the left/right block.


//	enum DemoType {
//		CompSort("Comparison Sort"),
//		LinearSort("Sorting in linear time"),
//		Problems("Problems (from StackOverflow.com, leetcode.com ...)"),
//		Test(""),
//		LinkedList("Single LinkedList Problem");
//
//		private final String desc;
//
//		DemoType(final String text) {
//			desc = text;
//		}
//
//	}



	// idx for generating the number

//	enum DemoItem{
//
//
//
//		//sortings
//		SortingComparasion(++sortIdx, DemoType.CompSort, SortingComparasionDemo.class),
//		InsertionSort(++sortIdx, DemoType.CompSort, InsertionSortDemo.class),
//		BubbleSort(++sortIdx, DemoType.CompSort, BubbleSortDemo.class),
//		MergeSort(++sortIdx, DemoType.CompSort, MergeSortDemo.class),
//		MergeSort_Optimized(++sortIdx, DemoType.CompSort, OptimizedMergeSortDemo.class),
//		HeapSort(++sortIdx, DemoType.CompSort, HeapSortDemo.class),
//		QuickSort(++sortIdx , DemoType.CompSort, QuickSortDemo.class),
//		RandomizedQuickSort(++sortIdx , DemoType.CompSort, RandomizedQuickSortDemo.class),
//
//		//sorting in linear time
//		CountingSort(++sortLinearIdx, DemoType.LinearSort, CountingSortDemo.class),
//		BucketSort(++sortLinearIdx, DemoType.LinearSort, BucketSortDemo.class),
//		RadixSort(++sortLinearIdx, DemoType.LinearSort, RadixSortDemo.class),
//
//		//linkedlist problems
//		ReverseLinkedList(++listIdx, DemoType.LinkedList, ReverseLinkedListDemo.class),
//		RotateList(++listIdx, DemoType.LinkedList, RotateListDemo.class),
//		SwapListNodesInPairs(++listIdx, DemoType.LinkedList, SwapListNodesInPairsDemo.class),
//		ReverseLinkedListEveryKNodes(++listIdx, DemoType.LinkedList, ReverseLinkedListEveryKNodesDemo.class),
//		RemoveDupsFromSortedLinkedList(++listIdx, DemoType.LinkedList, RemoveDupsFromSortedLinkedListDemo.class),
//		RemoveAllNodesHaveDupsFromSortedLinkedList(++listIdx, DemoType.LinkedList, RemoveAllNodesHaveDupsFromSortedLinkedListDemo.class),
//		RemoveNthNodeFromEndOfLinkedList(++listIdx, DemoType.LinkedList, RemoveNthNodeFromEndOfLinkedListDemo.class),
//		DetermineCircleInLinkedList(++listIdx, DemoType.LinkedList, DetermineCircleInLinkedListDemo.class),
//		DetermineCircleInLinkedListII(++listIdx, DemoType.LinkedList, DetermineCircleInLinkedListIIDemo.class),
//
//		//problems
//		MaxSubArray(++problemIdx, DemoType.Problems, MaxSubArrayDemo.class),
//		CountInversionPairs(++problemIdx, DemoType.Problems, CountInversionPairsDemo.class),
//		FindHeavyIntegers(++problemIdx, DemoType.Problems, FindHeavyIntegerDemo.class),
//		SortingIntegerWithNDigits(++problemIdx, DemoType.Problems, SortingIntegersWithNDigitsDemo.class),
//		SortingStringsWithNChars(++problemIdx, DemoType.Problems, SortingStringsWithNCharsDemo.class),
//		FindNextHigherNumber(++problemIdx, DemoType.Problems, FindNextHigherNumberDemo.class),
//		TwoSumInArray(++problemIdx, DemoType.Problems, TwoSumInArrayDemo.class),
//		PlusOne(++problemIdx, DemoType.Problems, PlusOneDemo.class),
//		ReverseInteger(++problemIdx, DemoType.Problems, ReverseIntegerDemo.class),
//		ReverseWordsInString(++problemIdx, DemoType.Problems, ReverseWordsInStringDemo.class),
//		MedianOfTwoSortedArrays(++problemIdx, DemoType.Problems, MedianOfTwoSortedArraysDemo.class),
//		FindAllSubSets(++problemIdx, DemoType.Problems, FindAllSubSetsDemo.class),
//		AddTwoNumbers(++problemIdx, DemoType.Problems, AddTwoNumbersDemo.class),
//		RemoveDupsFromSortedArray(++problemIdx, DemoType.Problems, RemoveDupsFromSortedArrayDemo.class),
//		FindLongestSubStrWithoutRepeatedChars(++problemIdx, DemoType.Problems, FindLongestSubStrWithoutRepeatedCharsDemo.class),
//		CheckPalindromeNumber(++problemIdx, DemoType.Problems, CheckPalindromeNumberDemo.class),
//		FindSingleNumber(++problemIdx, DemoType.Problems, FindSingleNumberDemo.class),
//		FindSingleNumberII(++problemIdx, DemoType.Problems, FindSingleNumberIIDemo.class),
//		ValidPalindrome(++problemIdx, DemoType.Problems, ValidPalindromeDemo.class);




		// @formatter:on



//		private final int idx;
//		private final Class<? extends AbstractDemo> demoClass;
//		private final DemoType type;
//
//		DemoItem(final int idx, final DemoType type, final Class<? extends AbstractDemo> demoClass) {
//			this.idx = idx;
//			this.demoClass = demoClass;
//			this.type = type;
//		}
//
//		public int getIdx() {
//			return idx;
//		}
//
//		public Class<? extends AbstractDemo> getDemoClass() {
//			return demoClass;
//		}
//
//		public static List<DemoItem> getItemsByDemoType(final DemoType type) {
//			return Lists.newArrayList(Collections2.filter(Arrays.asList(values()), new Predicate<DemoItem>() {
//				@Override
//				public boolean apply(final DemoItem input) {
//					return input.type == type;
//				}
//			}));
//		}

//		public static Map<Integer, Class<? extends AbstractDemo>> getMenuDemoMap() {
//			// mapping the menu idx to demo class
//			final Map<Integer, Class<? extends AbstractDemo>> map = new HashMap<Integer, Class<? extends AbstractDemo>>();
//
//			for (final DemoItem item : DemoItem.values()) {
//				map.put(item.getIdx(), item.getDemoClass());
//			}
//			return map;
//		}
//
//	}




	/**
	 * @param args
	 */
	public static void main(final String[] args) {


		Scanner scanner;
		int input = -9;
		String tmp;
		scanner = new Scanner(System.in);
		final ListMultimap<DemoType, DemoItem> demoMap = UiHelper.getDemoMap();
		//build the map for menu
		final Map<Integer, DemoItem> menuMap = Maps.newHashMap();
		for (DemoItem item : demoMap.values()) {
			menuMap.put(item.getIndex(), item);
		}


		// init
		while (input != 0) {
			try {

				AlgUtil.println(AlgUtil.repeatString("\n", 3));
				AlgUtil.println("Available Demos:");
				// AlgUtil.println(getDemoTypePrintList());
				UiHelper.printMenu(demoMap);
				AlgUtil.println(AlgUtil.repeatString("=", 77));
				if (input == -9) {

					AlgUtil.println("select the demo index (press 0 to exit):");
				} else if (!menuMap.containsKey(input)) {
					AlgUtil.println("unknow demo index, please input a valid demo index (0 to exit):");
				}
				tmp = scanner.nextLine();
				input = Integer.valueOf(tmp);
				if (input == 0) {
					break;
				}
				if (menuMap.containsKey(input)) {
					final AbstractDemo demo = menuMap.get(input).getDemoClass().newInstance();
					AlgUtil.println(AlgUtil.repeatString("\n", 2));
					AlgUtil.clear();
					AlgUtil.println("[ " + menuMap.get(input).getName() + " ]\n");
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



}
