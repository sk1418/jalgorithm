package com.kent.algorithm.sorting;

import java.util.Arrays;

import com.kent.algorithm.Sorting;
import com.kent.util.AlgUtil;

/**
 * 
 * <b>HeapSort</b><br/>
 * Sorting with Max-Heap (nearly a complete binary tree) data structure to sort.
 * <ol>
 * <li>build the Max heap</li>
 * <li>pop the root as the largest element, heapSize-1</li>
 * <li>max-heapify the rest heap nodes</li>
 * <li>continue step2 and 3 till the heap is empty.</li>
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
	public int[] sort(int[] data) {
		if (printSteps()) {
			AlgUtil.println("Init Heap:");
			AlgUtil.printBinaryTree(data, data.length, Integer.MIN_VALUE);
		}
		doHeapSort(data);
		return data;
	}

	private void doHeapSort(int[] a) {

		buildMaxHeap(a);

		if (printSteps()) {
			AlgUtil.println("Max Heap:");
			AlgUtil.printBinaryTree(a, HeapSize, Integer.MIN_VALUE);
		}

		for (int i = a.length - 1; i >= 1; i--) {
			AlgUtil.swap(a, 0, i);
			if (printSteps()) {
				AlgUtil.printBinaryTree(a, HeapSize, i);
				AlgUtil.print("array status:");
				AlgUtil.printIntArray(Arrays.copyOfRange(a, i, a.length));
			}
			HeapSize--;
			maxHeapify(a, 0);
			if (printSteps()) {
				AlgUtil.println("after max-heapifing:");
				AlgUtil.printBinaryTree(a, HeapSize, i);
			}
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
