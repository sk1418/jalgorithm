package com.kent.algorithm.sorting;

import org.apache.log4j.Logger;

import com.kent.algorithm.Sorting;
import com.kent.util.AlgUtil;

/**
 * 
 * <b>Selection sort</b><br/>
 * <ol>
 * <li>Find the minimum value in the list</li>
 * <li>Swap it with the value in the first position</li>
 * <li>Repeat the steps above for the remainder of the list (starting at the second position and advancing each time)</li>
 * 
 * </ol>
 * <p>
 * 
 * <b>Time complexity:</b> O(n^2)
 * </p>
 * 
 * @author kent
 * 
 */
public class SelectionSort extends Sorting {
	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(SelectionSort.class);

	@Override
	public String getBigO() {
		return "O(n^2)";
	}

	@Override
	public void sort(int[] data) {
		int minIdx;
		for (int i = 0; i < data.length; i++) {
			minIdx = i;
			for (int j = i + 1; j < data.length; j++) {
				if (data[j] < data[minIdx]) {
					minIdx = j;
				}
			}
			if (minIdx != i) {
				AlgUtil.swap(data, i, minIdx);
			}
		}
	}

}
