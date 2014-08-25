package com.kent.algorithm.demo.sorting;

import com.kent.algorithm.sorting.MergeSort;
import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoType;

/**
 * The Class InsertionSortDemo.
 */

@Demo(type = DemoType.CompSort, name = "Merge Sort")
public class MergeSortDemo extends AbstractSortingDemo {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void prepareDemo() {
        sorting = new MergeSort();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String demoDescription() {
        return "Merge Sort Demo";
    }

}
