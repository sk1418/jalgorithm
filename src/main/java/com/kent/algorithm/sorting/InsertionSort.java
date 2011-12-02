package com.kent.algorithm.sorting;

import org.apache.log4j.Logger;

import com.kent.algorithm.Sorting;

/**
 * 
 * <b>Insertion sort</b><br/>
 * <ol>
 * <li>using the 2nd element as key</li>
 * <li>compare key with element at left of Key's position.</li>
 * <li>if find element which is larger than key, insert Key before this
 * element(at left), till hit the element that smaller(or equals to) Key</li>
 * <li>take the next element (on right side) of key as new Key, repeat step 3.
 * till the last element as key.
 * <li>the left part of key is always sorted.</li>
 * </ol>
 * <p>
 * <b>Time complexity:</b> O(n^2)
 * </p>
 * 
 * @author kent
 * 
 */
public class InsertionSort extends Sorting {
	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(InsertionSort.class);

	@Override
	public void sort(int[] data) {
		int key;
		for (int i = 0; i < data.length; i++) {
			key = data[i];
			int j = i - 1;
			while (j >= 0 && data[j] > key) {
				data[j + 1] = data[j];
				j--;
			}

			data[j + 1] = key;
			// status after every step:
			// LOG.debug(Arrays.toString(data));

		}

	}
	@Override
	public String getBigO() {
		return "O(n^2)";
	}
	
}
