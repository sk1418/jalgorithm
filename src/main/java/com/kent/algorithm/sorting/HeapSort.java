package com.kent.algorithm.sorting;

import com.kent.algorithm.Sorting;
import com.kent.util.AlgUtil;

/**
 * 
 * <b>HeapSort</b><br/>
 * <ol>
 * <li></li>
 * <li></li>
 * <li></li>
 * <li></li>
 * </ol>
 * <p>
 * 
 * 
 * 
 * <br/>
 * <b>Time complexity:</b> O(nlogn)
 * </p>
 * 
 * @author kent
 * 
 */
public class HeapSort extends Sorting {

	private static int HeapSize;

	@Override
	public void sort(int[] data) {
		doHeapSort(data);
	}

	private void doHeapSort(int[] a) {
		buildMaxHeap(a);
		for (int i = a.length - 1; i >= 1; i--) {
			AlgUtil.swap(a, 0, i);
			HeapSize--;
			maxHeapify(a, 0);
		}
	}

	private void buildMaxHeap(int[] a) {
		HeapSize = a.length;
		for (int i = HeapSize / 2 - 1; i >= 0; i--) {
			// HeapSize/2 is the number of non-leaf nodes
			maxHeapify(a, i);
		}

	}

	/**
	 * maxHeapify - maintain a maxHeap by recursion
	 * 
	 * @param a
	 *            the array
	 * @param idx
	 *            the node need to be maintained.
	 */
	private void maxHeapify(int[] a, int idx) {
		int leftIdx = (idx << 1) + 1; // left = (2i + 1) 0based
		int rightIdx = idx + 1 << 1; // right = (i+1)2 0based
		int maxIdx = idx;

		while (leftIdx < HeapSize) {

			// find the max node idx among idx, left and right node.
			if (a[idx] < a[leftIdx]) {
				maxIdx = leftIdx;
			}

			if (rightIdx < HeapSize && a[rightIdx] > a[maxIdx]) {
				maxIdx = rightIdx;
			}
			if (maxIdx != idx) {
				AlgUtil.swap(a, maxIdx, idx);
				idx = maxIdx;
				leftIdx = (maxIdx << 1) + 1;
				rightIdx = maxIdx + 1 << 1;
			} else {
				return;
			}
		}

	}

	@Override
	public String getBigO() {
		return "O(nlog(n))";
	}

}
