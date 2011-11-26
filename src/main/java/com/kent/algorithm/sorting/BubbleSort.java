package com.kent.algorithm.sorting;

import org.apache.log4j.Logger;

import com.kent.util.Util;

/**
 * 
 * <b>Bubble Sort</b><br/>
 * <ol>
 * <li>set the 1st element as marker</li>
 * <li>from the end of array comparing adjoined elements till the marker</li>
 * <li>if the right element is smaller than the left, swap two elements</li>
 * <li>marker moving to the next at right, repeat step2.</li>
 * </ol>
 * <p>
 * 
 * <b>Time complexity:</b> O(n^2)
 * </p>
 * 
 * @author kent
 * 
 */
public class BubbleSort implements Sorting {
    /** The Constant LOG. */
    private static final Logger LOG = Logger.getLogger(BubbleSort.class);

    @Override
    public void sort(int[] data) {
	for (int i = 0; i < data.length; i++)
	    for (int j = data.length - 1; j > i; j--)
		if (data[j - 1] > data[j]) {
		    Util.swap(data, j, j - 1);
		    // LOG.debug(Arrays.toString(data));
		}

    }
}
