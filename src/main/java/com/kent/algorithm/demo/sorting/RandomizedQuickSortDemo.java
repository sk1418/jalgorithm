package com.kent.algorithm.demo.sorting;

import com.kent.algorithm.sorting.RandomizedQuickSort;
import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoType;

/**
 * The Class RandomizedQuickSortDemo.
 */

@Demo(type = DemoType.CompSort, name = "Quick(Randomized) Sort")
public class RandomizedQuickSortDemo extends AbstractSortingDemo {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void prepareDemo() {
        sorting = new RandomizedQuickSort();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String demoDescription() {
        return "RandomizedQuickSort Demo";
    }

}
