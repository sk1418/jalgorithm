package com.kent.algorithm.demo.sorting;

import com.kent.algorithm.sorting.InsertionSort;
import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoType;

/**
 * The Class InsertionSortDemo.
 */

@Demo(type = DemoType.CompSort, name = "Insertion Sort")
public class InsertionSortDemo extends AbstractSortingDemo {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void prepareDemo() {
        sorting = new InsertionSort();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String demoDescription() {
        return "Insertion Sort Demo";
    }

}
