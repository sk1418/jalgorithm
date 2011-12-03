package com.kent.algorithm.demo;

import java.util.LinkedList;
import java.util.List;

import com.kent.algorithm.Sorting;
import com.kent.algorithm.sorting.BubbleSort;
import com.kent.algorithm.sorting.InsertionSort;
import com.kent.algorithm.sorting.MergeSort;
import com.kent.algorithm.sorting.OptimizedMergeSort;
import com.kent.algorithm.sorting.SelectionSort;
import com.kent.util.AlgUtil;

/**
 * The Class SortingDemo.
 * 
 * Demo all sorting algorithms
 */
public class SortingDemo extends AbstractDemo {

	/** The Constant FMT. */
	private static final String FMT = "%-10s| %-21s| %7s ms.";

	/** The Constant SPL. */
	private static final String SPL = AlgUtil.lineSeparator('-', 45);

	/** The Constant SPLT. */
	private static final String SPLT = AlgUtil.lineSeparator('=', 45);

	/** The data. */
	private int[] data;

	/** The demo list. */
	private final List<Sorting> demoList = new LinkedList<Sorting>();

	/** {@inheritDoc} */
	@Override
	protected void specificDemo() {
		int[] testData;

		printInfo(String.format("Sorting %7s elements", data.length));
		printInfo(SPLT);
		for (int x = 1; x <= 5; x++) {
			for (final Sorting sort : demoList) {
				// cp array
				testData = new int[data.length];
				System.arraycopy(data, 0, testData, 0, data.length);
				System.gc();
				stopwatch.start();
				// sort
				sort.sort(testData);

				stopwatch.stop();

				printInfo(String.format(FMT, sort.getBigO(), sort.getClass().getSimpleName(), stopwatch.read()));
				printInfo(SPL);
				testData = null;

				stopwatch.reset();
			}
		}
	}

	/** {@inheritDoc} */
	@Override
	protected void prepareDemo() {
		data = AlgUtil.getRandomIntArray(BIG_ARRAY_SIZE, BIG_ARRAY_SIZE * 5, false);
		demoList.add(new InsertionSort());
		demoList.add(new SelectionSort());
		demoList.add(new BubbleSort());
		demoList.add(new MergeSort());
		demoList.add(new OptimizedMergeSort());

	}

	/** {@inheritDoc} */
	@Override
	protected void warmingUp() {
		for (final Sorting s : demoList) {
			s.sort(AlgUtil.getRandomIntArray(BIG_ARRAY_SIZE, BIG_ARRAY_SIZE * 5, false));
		}
	}

}
