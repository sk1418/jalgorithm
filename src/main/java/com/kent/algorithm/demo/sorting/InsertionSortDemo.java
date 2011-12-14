package com.kent.algorithm.demo.sorting;

import com.kent.algorithm.sorting.InsertionSort;

/**
 * The Class InsertionSortDemo.
 */
public class InsertionSortDemo extends AbstractSortingDemo {

	/** {@inheritDoc} */
	@Override
	protected void prepareDemo() {
		sorting = new InsertionSort();
	}

	/** {@inheritDoc} */
	@Override
	protected void printDescription() {
		print("Insertion Sort Demo");
	}

}
