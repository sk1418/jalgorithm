package com.kent.algorithm.demo.sorting;

import com.kent.algorithm.sorting.RandomizedQuickSort;

/**
 * The Class RandomizedQuickSortDemo.
 */
public class RandomizedQuickSortDemo extends AbstractSortingDemo {

	/** {@inheritDoc} */
	@Override
	protected void prepareDemo() {
		sorting = new RandomizedQuickSort();
	}

	/** {@inheritDoc} */
	@Override
	protected void printDescription() {
		print("RandomizedQuickSort Demo");
	}

}
