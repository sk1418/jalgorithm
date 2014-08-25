package com.kent.algorithm.demo.sorting;

import com.kent.algorithm.sorting.HeapSort;
import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoType;

/**
 * The Class HeapSortDemo.
 */
@Demo(type = DemoType.CompSort, name="Heap Sort")
public class HeapSortDemo extends AbstractSortingDemo {

	/** {@inheritDoc} */
	@Override
	protected void prepareDemo() {
		sorting = new HeapSort();
	}

	/** {@inheritDoc} */
	@Override
	protected String demoDescription() {
		print("Heap Sort Demo");
	}

}
