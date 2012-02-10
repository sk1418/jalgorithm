package com.kent.algorithm.sorting;

import static com.kent.util.AlgUtil.print;
import static com.kent.util.AlgUtil.printIntArray;
import static com.kent.util.AlgUtil.println;

import java.util.LinkedList;
import java.util.List;

import com.kent.algorithm.Sorting;

/**
 * <p>
 * BucketSort
 * </p>
 * <p>
 * 
 * The most common variant of bucket sort operates on a list of n numeric inputs between zero and some maximum value M and divides the value range
 * into n buckets each of size M/n. If each bucket is sorted using insertion sort, the sort can be shown to run in expected linear time (where the
 * average is taken over all possible inputs). However, the performance of this sort degrades with clustering; if many values occur close together,
 * they will all fall into a single bucket and be sorted slowly.
 * </p>
 * <p>
 * A common optimization is to put the elements back in the original array first, then run insertion sort over the complete array; because insertion
 * sort's runtime is based on how far each element is from its final position, the number of comparisons remains relatively small, and the memory
 * hierarchy is better exploited by storing the list contiguously in memory.
 * </p>
 * 
 */
public class BucketSort extends Sorting {

	/** The max value. */
	private int maxValue;
	private int minValue;
	private final int interval = 10;

	/** {@inheritDoc} */
	@Override
	public String getBigO() {
		return "O(n)";
	}

	/** {@inheritDoc} */
	@Override
	public int[] sort(int[] data) {

		final int numberOfBuckets = (maxValue - minValue) / interval + 1;
		final List<Integer>[] buckets = new List[numberOfBuckets];
		for (int i = 0; i < numberOfBuckets; i++) {
			buckets[i] = new LinkedList<Integer>();
		}

		if (printSteps()) {
			print("Original Array : ");
			printIntArray(data);
			println("");
		}

		// scatter
		for (final int e : data) {
			buckets[e / interval].add(e);
		}

		stepInfoAfterScattering(buckets);
		// gather: put the distributed linkedlist elements back to original array, then do insertSort on the complete array.
		int i = 0;
		for (int b = 0; b < numberOfBuckets; b++) {
			for (final int e : buckets[b]) {
				data[i++] = e;
			}
		}
		if (printSteps()) {
			println("Gathering: put element in buckets back to original Array : ");
			printIntArray(data);
			println("");
		}

		// insertion Sort on data
		int k;
		for (int x = 1; x < data.length; x++) {
			k = data[x];
			int j = x - 1;
			while (j >= 0 && data[j] > k) {
				data[j + 1] = data[j];
				j--;
			}
			data[j + 1] = k;

		}
		if (printSteps()) {
			println("Do insert Sort on original array:");
			printIntArray(data);
			println("");
		}

		return data;
	}

	private void stepInfoAfterScattering(List<Integer>[] buckets) {
		if (printSteps()) {
			println("");
			println("scattering: distribute the elements into buckets:");
			for (int i = 0; i < buckets.length; i++) {
				print("Bucket " + i * interval + " - " + (1 + i) * interval + " : ");

				for (int j = 0; j < buckets[i].size(); j++) {
					print(String.valueOf(buckets[i].get(j)).concat(j == buckets[i].size() - 1 ? "" : ", "));
				}
				println("");
			}
		}
	}

	/**
	 * Sets the max value.
	 * 
	 * @param maxValue
	 *            the new max value
	 */
	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}

	public void setMinValue(int minValue) {
		this.minValue = minValue;
	}

}
