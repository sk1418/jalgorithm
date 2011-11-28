package com.kent.algorithm.demo;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.kent.algorithm.sorting.Sorting;
import com.kent.util.Stopwatch;

public class SortingDemo {
    /** The Constant LOG. */
    private static final Logger LOG = Logger.getLogger(SortingDemo.class);

    private int[] data;
    List<Sorting> demoList = new LinkedList<Sorting>();

    public void demo() {
	prepareDemo();
	final Stopwatch stopwatch = new Stopwatch();
	for (final Sorting sort : demoList) {
	    stopwatch.start();
	    sort.sort(data);
	    stopwatch.stop();
	    LOG.info(sort.getName() + " took " + stopwatch.read() + " ms.");
	    stopwatch.reset();
	}
    }

    private void prepareDemo() {

    }
}
