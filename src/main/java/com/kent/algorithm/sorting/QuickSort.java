package com.kent.algorithm.sorting;

import com.kent.algorithm.Sorting;
import com.kent.util.AlgUtil;

/**
 * 
 * <b>Quicksort</b><br/>
 * <p>
 * Divid-And-Conquer algorithm.
 * 
 * Partitioning is the key part.
 * </p>
 * 
 * 
 * <ol>
 * <li>select the last element(r) as pivot.</li>
 * <li>all elements with index 0->i are smaller than pivot, and all elements with index i-(r-1) are greater than pivot</li>
 * <li>recursively partitioning, will finish the sorting.</li>
 * </ol>
 * <p>
 * 
 * <br/>
 * <b>Time complexity:</b>
 * 
 * <br/>
 * worst case:O(n^2) <br/>
 * average O(nlogn)
 * </p>
 * <p>
 * <b>quote from wikipedia:<br/>
 * </b> <b>Comparison with other sorting algorithms</b><br>
 * Quicksort is a space-optimized version of the binary tree sort. Instead of inserting items sequentially into an explicit tree, quicksort organizes
 * them concurrently into a tree that is implied by the recursive calls. The algorithms make exactly the same comparisons, but in a different order.
 * An often desirable property of a sorting algorithm is stability - that is the order of elements that compare equal is not changed, allowing
 * controlling order of multikey tables (e.g. directory or folder listings) in a natural way. This property is hard to maintain for in situ (or in
 * place) quicksort (that uses only constant additional space for pointers and buffers, and logN additional space for the management of explicit or
 * implicit recursion). For variant quicksorts involving extra memory due to representations using pointers (e.g. lists or trees) or files
 * (effectively lists), it is trivial to maintain stability. The more complex, or disk-bound, data structures tend to increase time cost, in general
 * making increasing use of virtual memory or disk.
 * </p>
 * <p>
 * The most direct competitor of quicksort is heapsort. Heapsort's worst-case running time is always O(n log n). But, heapsort is assumed to be on
 * average somewhat slower than standard in-place quicksort. This is still debated and in research, with some publications indicating the
 * opposite.[13][14] Introsort is a variant of quicksort that switches to heapsort when a bad case is detected to avoid quicksort's worst-case running
 * time. If it is known in advance that heapsort is going to be necessary, using it directly will be faster than waiting for introsort to switch to
 * it.
 * </P>
 * <p>
 * Quicksort also competes with mergesort, another recursive sort algorithm but with the benefit of worst-case O(n log n) running time. Mergesort is a
 * stable sort, unlike standard in-place quicksort and heapsort, and can be easily adapted to operate on linked lists and very large lists stored on
 * slow-to-access media such as disk storage or network attached storage. Like mergesort, quicksort can be implemented as an in-place stable sort
 * [15], but this is seldom done. Although quicksort can be written to operate on linked lists, it will often suffer from poor pivot choices without
 * random access. The main disadvantage of mergesort is that, when operating on arrays, efficient implementations require O(n) auxiliary space,
 * whereas the variant of quicksort with in-place partitioning and tail recursion uses only O(log n) space. (Note that when operating on linked lists,
 * mergesort only requires a small, constant amount of auxiliary storage.)
 * </p>
 * <p>
 * Bucket sort with two buckets is very similar to quicksort; the pivot in this case is effectively the value in the middle of the value range, which
 * does well on average for uniformly distributed inputs.
 * </p>
 * 
 * @author kent
 * 
 */
public class QuickSort extends Sorting {

	/** {@inheritDoc} */
	@Override
	public String getBigO() {
		return "O(n^2)-O(nlog(n))";
	}

	/** {@inheritDoc} */
	@Override
	public int[] sort(final int[] data) {
		quickSort(data, 0, data.length - 1);
		return data;

	}

	/**
	 * do Quick sort.
	 * 
	 * @param a
	 *            the array need to be sorted
	 * @param p
	 *            the p the start index of sorting
	 * @param r
	 *            the r the end index of sorting
	 */
	public void quickSort(final int[] a, final int p, final int r) {
		final int q = patition(a, p, r);
		// print step info
		if (printSteps()) {
			AlgUtil.printIntArray(a);
		}
		if (q > p) {
			quickSort(a, p, q - 1);
		}
		if (q < r) {
			quickSort(a, q + 1, r);
		}
	}

	/**
	 * Patition. Key part of quickSort algorithm
	 * 
	 * @param a
	 *            the a the array
	 * @param p
	 *            the p start index
	 * @param r
	 *            the r end index
	 * @return the partition index.
	 */
	private int patition(final int[] a, final int p, final int r) {

		// set the last element as pivot
		final int pivot = a[r];
		int i = p - 1, j = p;
		for (; j < r; j++) {
			if (a[j] < pivot) {
				i++;
				AlgUtil.swap(a, i, j);
			}
		}
		// swap a[i+1] and pivot
		AlgUtil.swap(a, i + 1, r);
		return i + 1;
	}

}
