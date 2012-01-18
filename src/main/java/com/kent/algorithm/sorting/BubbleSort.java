package com.kent.algorithm.sorting;

import com.kent.algorithm.Sorting;
import com.kent.util.AlgUtil;

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
 * 
 * The Jargon file, which famously calls bogosort "the archetypical perversely awful algorithm", also calls bubble sort "the generic bad algorithm".
 * Donald Knuth, in his famous book The Art of Computer Programming, concluded that
 * "the bubble sort seems to have nothing to recommend it, except a catchy name and the fact that it leads to some interesting theoretical problems",
 * some of which he then discusses. <br/>
 * Bubble sort is asymptotically equivalent in running time to insertion sort in the worst case, but the two algorithms differ greatly in the number
 * of swaps necessary. Experimental results such as those of Astrachan have also shown that insertion sort performs considerably better even on random
 * lists. For these reasons many modern algorithm textbooks avoid using the bubble sort algorithm in favor of insertion sort.
 * 
 * <br/>
 * <b>Time complexity:</b> O(n^2)
 * </p>
 * 
 * @author kent
 * 
 */
public class BubbleSort extends Sorting {

	@Override
	public int[] sort(int[] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = data.length - 1; j > i; j--) {
				if (data[j - 1] > data[j]) {
					AlgUtil.swap(data, j, j - 1);

					// status after every step:
					if (printSteps()) {
						AlgUtil.printIntArray(data);
					}
				}
			}
		}

		return data;
	}

	@Override
	public String getBigO() {
		return "O(n^2)";
	}

}
