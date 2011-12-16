package com.kent.algorithm.demo.sorting;

import com.kent.algorithm.sorting.MergeSort;

/**
 * The Class InsertionSortDemo.
 */
public class MergeSortDemo extends AbstractSortingDemo {

	/** {@inheritDoc} */
	@Override
	protected void prepareDemo() {
		sorting = new MergeSort();
	}

	/** {@inheritDoc} */
	@Override
	protected void printDescription() {
		print("Merge Sort Demo");
	}

}
