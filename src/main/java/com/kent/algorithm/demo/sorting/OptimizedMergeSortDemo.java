package com.kent.algorithm.demo.sorting;

import com.kent.algorithm.sorting.OptimizedMergeSort;

/**
 * The Class InsertionSortDemo.
 */
public class OptimizedMergeSortDemo extends AbstractSortingDemo {

	/** {@inheritDoc} */
	@Override
	protected void prepareDemo() {
		sorting = new OptimizedMergeSort();
	}

	/** {@inheritDoc} */
	@Override
	protected void printDescription() {
		print("Optimized Merge Sort Demo");
	}

}
