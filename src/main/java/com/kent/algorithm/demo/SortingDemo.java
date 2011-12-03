package com.kent.algorithm.demo;

import java.util.LinkedList;
import java.util.List;

import com.kent.algorithm.Sorting;
import com.kent.algorithm.sorting.InsertionSort;
import com.kent.algorithm.sorting.MergeSort;
import com.kent.algorithm.sorting.OptimizedMergeSort;
import com.kent.util.AlgUtil;

/**
 * The Class SortingDemo.
 * 
 * Demo all sorting algorithms
 */
public class SortingDemo extends AbstractDemo {
	private static final String FMT = "%-10s| %-21s| %7s ms.";
	private static final String SPL = AlgUtil.lineSeparator('-', 45);
	private static final String SPLT = AlgUtil.lineSeparator('=', 45);

	private int[] data;

	private final List<Sorting> demoList = new LinkedList<Sorting>();

	@Override
	protected void specificDemo() {

		int[] testData;

		printInfo(String.format("Sorting %7s elements", data.length));
		printInfo(SPLT);
		for (final Sorting sort : demoList) {
			// cp array
			testData = new int[data.length];
			System.arraycopy(data, 0, testData, 0, data.length);
			stopwatch.start();
			// sort
			sort.sort(testData);

			stopwatch.stop();

			printInfo(String.format(FMT, sort.getBigO(), sort.getClass().getSimpleName(), stopwatch.read()));
			printInfo(SPL);

			stopwatch.reset();
		}
	}

	@Override
	protected void prepareDemo() {
		data = AlgUtil.getRandomIntArray(BIG_ARRAY_SIZE, BIG_ARRAY_SIZE * 5, false);
		demoList.add(new InsertionSort());
		// demoList.add(new SelectionSort());
		// demoList.add(new BubbleSort());
		demoList.add(new MergeSort());
		demoList.add(new OptimizedMergeSort());

	}

	public static void main(final String[] args) {
		final AbstractDemo sortingDemo = new SortingDemo();
		sortingDemo.doDemo();
	}
}
