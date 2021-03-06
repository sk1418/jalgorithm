package com.kent.algorithm.demo.sorting;

import com.kent.algorithm.Sorting;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.sorting.*;
import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoType;
import com.kent.util.AlgUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * The Class SortingComparisionDemo.
 */

@Demo(type = DemoType.CompSort, name = "~> Compare Sort algorithms <~")
public class SortingComparisionDemo extends AbstractDemo {

    /**
     * The Constant FMT.
     */
    private static final String FMT = "%-20s| %-21s| %7s ms.";

    /**
     * The Constant SPL.
     */
    private static final String SPL = AlgUtil.repeatString("-", 65);

    /**
     * The Constant SPLT.
     */
    private static final String SPLT = AlgUtil.repeatString("=", 65);

    /**
     * The data.
     */
    private int[] data;

    /**
     * The demo list.
     */
    private final List<Sorting> demoList = new LinkedList<Sorting>();

    /**
     * {@inheritDoc}
     */
    @Override
    protected void specificDemo() {
        int[] testData;

        print(String.format("Sorting %7s elements", data.length));
        print(SPLT);
        print(String.format(FMT, "Sort", "Complexity(BigO)", "time elasped -"));
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

            print(String.format(FMT, sort.getClass().getSimpleName(), sort.getBigO(), stopwatch.read()));
            print(SPL);
            testData = null;

            stopwatch.reset();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void prepareDemo() {
        data = AlgUtil.getRandomIntArray(BIG_ARRAY_SIZE, BIG_ARRAY_SIZE * 5, false);
        demoList.add(new InsertionSort());
        demoList.add(new SelectionSort());
        demoList.add(new BubbleSort());
        demoList.add(new MergeSort());
        demoList.add(new OptimizedMergeSort());
        demoList.add(new HeapSort());
        demoList.add(new QuickSort());
        demoList.add(new RandomizedQuickSort());

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void warmingUp() {
        for (final Sorting s : demoList) {
            s.sort(AlgUtil.getRandomIntArray(BIG_ARRAY_SIZE, BIG_ARRAY_SIZE * 5, false));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String demoDescription() {
        return "compare different sort algorithms:";
    }

}
