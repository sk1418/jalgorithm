package com.kent.algorithm.demo.sorting;

import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoType;
import com.kent.algorithm.sorting.BucketSort;
import com.kent.util.AlgUtil;

/**
 * The Class BucketSortDemo.
 */
@Demo( name="Bucket Sort", type = DemoType.LinearSort)
public class BucketSortDemo extends AbstractSortingDemo {

	/** {@inheritDoc} */
	@Override
	protected void prepareDemo() {
		data = AlgUtil.getRandomIntArray(SMALL_ARRAY_SIZE, SMALL_ARRAY_SIZE * 3, false);
		final BucketSort bs = new BucketSort();
		bs.setMaxValue(SMALL_ARRAY_SIZE * 3);
		bs.setMinValue(1);
		bs.setPrintSteps(true);

		sorting = bs;
	}

	/** {@inheritDoc} */
	@Override
	protected void printDescription() {
		print("Bucket Sort Demo");
	}

	@Override
	protected void warmingUp() {
		// do not need warmingUp
	}
}
