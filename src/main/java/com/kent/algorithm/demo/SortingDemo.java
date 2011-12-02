package com.kent.algorithm.demo;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.kent.algorithm.Sorting;
import com.kent.algorithm.sorting.BubbleSort;
import com.kent.algorithm.sorting.InsertionSort;
import com.kent.algorithm.sorting.MergeSort;
import com.kent.algorithm.sorting.SelectionSort;
import com.kent.util.AlgUtil;

public class SortingDemo extends Demo {
	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(SortingDemo.class);
	private final String FMT = "%-10s| %-15s| %7s ms.";
	private final String SPL = AlgUtil.lineSeparator('-', 40);
	private final String SPLT = AlgUtil.lineSeparator('=', 40);

	private int[] data;

	List<Sorting> demoList = new LinkedList<Sorting>();

	@Override
	protected void specificDemo() {

		final int[] testData = new int[data.length];

		printInfo(String.format("Sorting %7s elements", data.length));
		printInfo(SPLT);
		for (final Sorting sort : demoList) {
			// cp array
			System.arraycopy(data, 0, testData, 0, data.length);

			stopwatch.start();
			// sort
			sort.sort(testData);

			stopwatch.stop();

			printInfo(String.format(FMT,  sort.getBigO(),sort.getClass().getSimpleName(), stopwatch.read()));
			printInfo(SPL);

			stopwatch.reset();
		}
	}

	@Override
	protected void prepareDemo() {
		data = AlgUtil.getRandomIntArray(BIG_ARRAY_SIZE, BIG_ARRAY_SIZE*5);
		demoList.add(new InsertionSort());
		demoList.add(new SelectionSort());
		demoList.add(new BubbleSort());
		demoList.add(new MergeSort());

	}

	public static void main(String[] args) {
		final Demo sortingDemo = new SortingDemo();
		sortingDemo.doDemo();
	}
}
