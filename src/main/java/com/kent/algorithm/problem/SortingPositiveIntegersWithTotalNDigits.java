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
		return data;
	}

	/**
	 * using counting sort distribute the input Array against the number of digits
	 * 
	 * @param input
	 */
	private int[][] scattering(int[] input) {
		final int d = findMaxDigits(input);
		final int[][] groups = new int[d + 1][0];
		for (int i = 0; i < input.length; i++) {
			final int e = input[i];
			final int di = (int) Math.log10(e) + 1;
			groups[di] = AlgUtil.addIntToArray(groups[di], e);
		}
		return groups;
	}

	private int findMaxDigits(int[] input) {
		final int maxE = findMaxElement(input);
		return (int) Math.log10(maxE) + 1;
	}

	/**
	 * O(m)
	 * 
	 * @param input
	 * @return
	 */
	private int findMaxElement(int[] input) {
		int max = 0;
		for (final int e : input) {
			max = e > max ? e : max;
		}
		return max;
	}
}
