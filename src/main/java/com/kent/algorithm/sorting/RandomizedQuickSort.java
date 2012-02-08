package com.kent.algorithm.sorting;

import com.kent.util.AlgUtil;

/**
 * RandomizedQuickSort
 * 
 * In Partition phase, not always choosing the last element as pivot, but randomly selecting an element, exchange it with last element. then do the
 * normal partitioning.
 * 
 */
public class RandomizedQuickSort extends QuickSort {

	/** {@inheritDoc} */
	@Override
	protected int partition(int[] a, int p, int r) {
		int randomIdx = AlgUtil.getRandomInRange(p, r);
		AlgUtil.swap(a, randomIdx, r);
		return super.partition(a, p, r);
	}

}
