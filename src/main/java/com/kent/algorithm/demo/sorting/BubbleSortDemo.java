package com.kent.algorithm.demo.sorting;

import com.kent.algorithm.sorting.BubbleSort;
import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoType;

/**
 * The Class BubbleSortDemo.
 */
@Demo(name = "Bubble Sort",
        type = DemoType.CompSort)
public class BubbleSortDemo extends AbstractSortingDemo {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void prepareDemo() {
        sorting = new BubbleSort();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String demoDescription() {
        return "Bubble Sort Demo";
    }

}
