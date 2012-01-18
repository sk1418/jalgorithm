package com.kent.algorithm.problem;

import com.kent.algorithm.Problem;
import com.kent.algorithm.sorting.RadixSort;
import com.kent.util.AlgUtil;

/**
 * <p>
 * You are given an array of integers, where different integers may have different numbers of digits, but the total number of digits over all the
 * integers in the array is n. Show how to sort the array in O(n) time.
 * </p>
 * <p>
 * 
 * Let us assume that all the integers are positive and have no leading zeros. Under this assumption, we can observe that integers with more digits
 * are always greater than integers with fewer digits. Thus, we can first sort the integers by number of digits (using counting sort), and then use
 * radix sort to sort each group of integers with the same length.
 * 
 * </p>
 * 
 * @author kent
 * 
 */
public class SortingPositiveIntegersWithTotalNDigits extends Problem<int[], int[]> {

	private RadixSort radixSort = new RadixSort();

	@Override
	public String getBigO() {
		return "O(n) [n is total number of digits]";
	}

	@Override
	public int[] solve(int[] data) {
		final int[][] groups = scattering(data);

		int[] tmp;
		int j = 0;

		for (int i = 1; i < groups.length; i++) {
			radixSort.setFixDigits(i);
			tmp = radixSort.sort(groups[i]);
			for (final int t : tmp) {
				data[j++] = t;
			}
		}
		if (printSteps()) {
			AlgUtil.println("finally sort each group with radix sort: ");
			AlgUtil.printIntArray(data);
		}

		return data;
	}

	/**
	 * using counting sort distribute the input Array against the number of digits
	 * 
	 * @param input
	 */
	private int[][] scattering(int[] input) {
		final int d = findMaxDigits(input);
		// print info
		if (printSteps()) {
			AlgUtil.println("Max digits among all elements : " + d);
		}
		final int[][] groups = new int[d + 1][0];
		for (int i = 0; i < input.length; i++) {
			final int e = input[i];
			final int di = (int) Math.log10(e) + 1;
			groups[di] = AlgUtil.addIntToArray(groups[di], e);
		}

		// print info
		AlgUtil.println("group elements by digits numbers : ");
		printGroupsInfo(groups);
		return groups;

	}

	private void printGroupsInfo(final int[][] groups) {
		if (printSteps()) {
			final String fmt = " numbers with %2d digits : ";
			for (int x = 1; x < groups.length; x++) {
				AlgUtil.print(String.format(fmt, x));
				AlgUtil.printIntArray(groups[x]);
			}
		}
	}

	/**
	 * find the largest digits among all elements
	 * 
	 * @param input
	 * @return
	 */
	private int findMaxDigits(int[] input) {
		int maxE = 0;
		for (final int e : input) {
			maxE = e > maxE ? e : maxE;
		}
		return (int) Math.log10(maxE) + 1;
	}

}
