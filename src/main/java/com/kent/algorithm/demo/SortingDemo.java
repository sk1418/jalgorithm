package com.kent.algorithm.demo;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.kent.algorithm.sorting.BubbleSort;
import com.kent.algorithm.sorting.InsertionSort;
import com.kent.algorithm.sorting.MergeSort;
import com.kent.algorithm.sorting.SelectionSort;
import com.kent.algorithm.sorting.Sorting;
import com.kent.util.AlgUtil;
import com.kent.util.Stopwatch;

public class SortingDemo {
	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(SortingDemo.class);
	private final String FMT = "%-15s| %7s ms.";
	private final String SPL = "-----------------------------";
	private final String SPLT = "=============================";

	private int[] data;
	private Stopwatch stopwatch;

	List<Sorting> demoList = new LinkedList<Sorting>();

	public void demo() {
		prepareDemo();
		final int[] testData = new int[data.length];

		LOG.info(String.format("Sorting %7s elements", data.length));
		LOG.info(SPLT);
		for (final Sorting sort : demoList) {
			// cp array
			System.arraycopy(data, 0, testData, 0, data.length);

			stopwatch.start();
			// sort
			sort.sort(testData);

			stopwatch.stop();

			LOG.info(String.format(FMT, sort.getClass().getSimpleName(), stopwatch.read()));
			LOG.info(SPL);

			stopwatch.reset();
		}
	}

	private void prepareDemo() {
		data = AlgUtil.getRandomIntArray(20000, 500000);
		stopwatch = new Stopwatch();
		demoList.add(new InsertionSort());
		demoList.add(new SelectionSort());
		demoList.add(new BubbleSort());
		demoList.add(new MergeSort());

	}

	public static void main(String[] args) {
		new SortingDemo().demo();
	}
}
