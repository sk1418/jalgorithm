package com.kent.algorithm.demo.sorting;

import com.kent.algorithm.sorting.QuickSort;
import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoType;

/**
 * The Class QuickSortDemo.
 */

@Demo(type = DemoType.CompSort, name="Quick Sort")
public class QuickSortDemo extends AbstractSortingDemo {

	/** {@inheritDoc} */
	@Override
	protected void prepareDemo() {
		sorting = new QuickSort();
	}

	/** {@inheritDoc} */
	@Override
	protected String demoDescription() {
		print("Quick Sort Demo");
	}

}
