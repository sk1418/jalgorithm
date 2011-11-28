package com.kent.algorithm.sorting;

import org.apache.log4j.Logger;

import com.kent.util.AlgUtil;

/**
 * 
 * <b>Selection sort</b><br/>
 * <ol>
 * <li>initially pointer is at the 1st element</li>
 * <li>find the smallest element from the element next to pointer to the last element</li>
 * <li>if the min smaller than the pointer, swap the two elements</li>
 * <li>pointer moving to the next at right, repeat step2.</li>
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
    public void sort(int[] data) {
	for (int i = 0; i < data.length; i++) {
	    for (int j = i + 1; j < data.length; j++) {
		if (data[j] < data[i]) {
		    AlgUtil.swap(data, i, j);
		}
	    }
	}
    }

}
