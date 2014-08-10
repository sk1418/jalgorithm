package com.kent.algorithm.demo.sorting;

import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoType;
import com.kent.algorithm.sorting.BubbleSort;

/**
 * The Class BubbleSortDemo.
 */
@Demo(name="Bubble Sort",
	type = DemoType.LinearSort)
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
