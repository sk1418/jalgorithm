package com.kent.algorithm.demo.sorting;

import java.util.LinkedList;
import java.util.List;

import com.kent.algorithm.Sorting;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.sorting.BubbleSort;
import com.kent.algorithm.sorting.HeapSort;
import com.kent.algorithm.sorting.InsertionSort;
import com.kent.algorithm.sorting.MergeSort;
import com.kent.algorithm.sorting.OptimizedMergeSort;
import com.kent.algorithm.sorting.SelectionSort;
import com.kent.util.AlgUtil;

/**
 * The Class SortingComparasionDemo.
 */
public class SortingComparasionDemo extends AbstractDemo {

	/** The Constant FMT. */
	private static final String FMT = "%-10s| %-21s| %7s ms.";

	/** The Constant SPL. */
	private static final String SPL = AlgUtil.repeatString("-", 45);

	/** The Constant SPLT. */
	private static final String SPLT = AlgUtil.repeatString("=", 45);

	/** The data. */
	private int[] data;

	/** The demo list. */
	private final List<Sorting> demoList = new LinkedList<Sorting>();

	/** {@inheritDoc} */
	@Override
	protected void specificDemo() {
		int[] testData;

		print(String.format("Sorting %7s elements", data.length));
		print(SPLT);
		for (final Sorting sort : demoList) {
			// cp array
			testData = new int[data.length];
			System.arraycopy(data, 0, testData, 0, data.length);
			System.gc();
			stopwatch.start();
			// sort
			sort.sort(testData);

			stopwatch.stop();

			print(String.format(FMT, sort.getBigO(), sort.getClass().getSimpleName(), stopwatch.read()));
			print(SPL);
			testData = null;

			stopwatch.reset();
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
		demoList.add(new HeapSort());

	}

	/** {@inheritDoc} */
	@Override
	protected void warmingUp() {
		for (final Sorting s : demoList) {
			s.sort(AlgUtil.getRandomIntArray(BIG_ARRAY_SIZE, BIG_ARRAY_SIZE * 5, false));
		}
	}

	/** {@inheritDoc} */
	@Override
	protected void printDescription() {
		print("compare different sort algorithms:");
	}

}
