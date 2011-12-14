package com.kent.algorithm.demo.sorting;

import com.kent.algorithm.sorting.BubbleSort;

/**
 * The Class BubbleSortDemo.
 */
public class BubbleSortDemo extends AbstractSortingDemo {

	/** {@inheritDoc} */
	@Override
	protected void prepareDemo() {
		sorting = new BubbleSort();
	}

	/** {@inheritDoc} */
	@Override
	protected void printDescription() {
		print("Bubble Sort Demo");
	}

}
