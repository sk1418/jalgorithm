package com.kent.algorithm.demo.sorting;

import com.kent.algorithm.sorting.RadixSort;
import com.kent.util.AlgUtil;

/**
 * The Class RadixSortDemo.
 */
public class RadixSortDemo extends AbstractSortingDemo {

	/** {@inheritDoc} */
	@Override
	protected void prepareDemo() {
		data = AlgUtil.getRandomIntArray(SMALL_ARRAY_SIZE, SMALL_ARRAY_SIZE * 300, false);
		final RadixSort rs = new RadixSort();
		rs.setPrintSteps(true);

		sorting = rs;
	}

	/** {@inheritDoc} */
	@Override
	protected void printDescription() {
		print("Radix Sort Demo");
	}

	@Override
	protected void warmingUp() {
		// warmingUp is not needed.
	}
}
