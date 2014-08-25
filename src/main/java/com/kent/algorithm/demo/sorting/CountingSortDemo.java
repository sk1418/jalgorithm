package com.kent.algorithm.demo.sorting;

import com.kent.algorithm.sorting.CountingSort;
import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoType;
import com.kent.util.AlgUtil;

/**
 * The Class CountingSortDemo.
 */
@Demo( name="Counting Sort", type = DemoType.LinearSort)
public class CountingSortDemo extends AbstractSortingDemo {

	/** {@inheritDoc} */
	@Override
	protected void prepareDemo() {
		data = AlgUtil.getRandomIntArray(SMALL_ARRAY_SIZE, SMALL_ARRAY_SIZE - 3, false);
		CountingSort cs = new CountingSort();
		cs.setMaxValue(SMALL_ARRAY_SIZE - 3);

		sorting = cs;
	}

	/** {@inheritDoc} */
	@Override
	protected String demoDescription() {
		print("Counting Sort Demo");
	}

	@Override
	protected void warmingUp() {
		sorting.setPrintSteps(false);
		sorting.sort(data);
		sorting.setPrintSteps(true);
	}
}
