package com.kent.algorithm.demo.sorting;

import com.kent.algorithm.sorting.OptimizedMergeSort;
import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoType;

/**
 * The Class InsertionSortDemo.
 */

@Demo(type = DemoType.CompSort, name = "Merge(Optimized) Sort")
public class OptimizedMergeSortDemo extends AbstractSortingDemo {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void prepareDemo() {
        sorting = new OptimizedMergeSort();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String demoDescription() {
        return "Optimized Merge Sort Demo";
    }

}
