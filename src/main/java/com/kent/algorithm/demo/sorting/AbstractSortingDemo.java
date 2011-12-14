package com.kent.algorithm.demo.sorting;

import java.util.Arrays;

import com.kent.algorithm.Sorting;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.util.AlgUtil;

/**
 * The Class AbstractSortingDemo.
 */
public abstract class AbstractSortingDemo extends AbstractDemo {

	/** The data. */
	protected int[] data = AlgUtil.getRandomIntArray(SMALL_ARRAY_SIZE, SMALL_ARRAY_SIZE * 17, false);

	/** The sorting. */
	protected Sorting sorting;

	/** {@inheritDoc} */
	@Override
	protected void specificDemo() {

		print("Sorting array:" + Arrays.toString(data));
		print(SPLT);
		print(Arrays.toString(data));
		// cp array
		stopwatch.start();
		// sort
		sorting.sort(data);

		stopwatch.stop();
		print(SPLT);
		print("Time elapsed:" + stopwatch.read());
		stopwatch.reset();
	}

	/** {@inheritDoc} */
	@Override
	protected void warmingUp() {
		sorting.setPrintSteps(false);
		sorting.sort(AlgUtil.getRandomIntArray(SMALL_ARRAY_SIZE, SMALL_ARRAY_SIZE * 17, false));
		sorting.setPrintSteps(true);
	}

}
