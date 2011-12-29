package com.kent.algorithm.demo.sorting;

import com.kent.algorithm.sorting.QuickSort;

/**
 * The Class QuickSortDemo.
 */
public class QuickSortDemo extends AbstractSortingDemo {

	/** {@inheritDoc} */
	@Override
	protected void prepareDemo() {
		sorting = new QuickSort();
	}

	/** {@inheritDoc} */
	@Override
	protected void printDescription() {
		print("Quick Sort Demo");
	}

}
