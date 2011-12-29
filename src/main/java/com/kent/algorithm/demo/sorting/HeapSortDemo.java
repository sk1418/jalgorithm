package com.kent.algorithm.demo.sorting;

import com.kent.algorithm.sorting.HeapSort;

/**
 * The Class HeapSortDemo.
 */
public class HeapSortDemo extends AbstractSortingDemo {

	/** {@inheritDoc} */
	@Override
	protected void prepareDemo() {
		sorting = new HeapSort();
	}

	/** {@inheritDoc} */
	@Override
	protected void printDescription() {
		print("Heap Sort Demo");
	}

}
