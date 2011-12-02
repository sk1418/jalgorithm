package com.kent.algorithm.problem;

import org.apache.log4j.Logger;

/**
 * @author kent
 * 
 */
public class MaxSubArray extends Problem<int[], int[]> {

	private static final Logger LOG = Logger.getLogger(MaxSubArray.class);

	private int[] array = null;
	private int start = 0;
	private int end = 0;
	private int maxSum = Integer.MIN_VALUE;

	/**
	 * find the maxSubArray (the subMaxArray of @para data, which have max sum of all elements)
	 * 
	 * @param data
	 *            the array
	 * @return a tuple int[3]={startIdx, endIdx, maxSum}
	 */
	@Override
	public int[] solve(int[] data) {
		int[] result = null;
		if (data != null) {
			this.array = data;
			result = findMaxSubArray(data, 0, data.length - 1);
			this.start = result[0];
			this.end = result[1];
			this.maxSum = result[2];
		}

		return result;
	}

	// @Override
	// protected void output() {
	// LOG.info("from index :" + start);
	// LOG.info("end  index :" + end);
	// LOG.info("Max  Sum   :" + maxSum);
	// LOG.info("Sub Array  :" + Arrays.toString(Arrays.copyOfRange(array, start, end + 1)));
	// }

	private int[] findMaxSubArray(int[] a, int from, int to) {
		if (from == to) {
			return new int[] { from, to, a[from] };
		} else {

			final int mid = (from + to) / 2;

			final int[] leftResult = findMaxSubArray(a, from, mid);
			final int[] rightResult = findMaxSubArray(a, mid + 1, to);
			final int[] crossResult = findMaxCrossingSubArray(a, from, mid, to);

			if (leftResult[2] >= crossResult[2] && leftResult[2] >= rightResult[2]) {
				return leftResult;
			} else if (rightResult[2] >= crossResult[2] && rightResult[2] >= leftResult[2]) {
				return rightResult;
			} else {
				return crossResult;
			}
		}

	}

	private int[] findMaxCrossingSubArray(int[] a, int from, int mid, int to) {
		int maxLeftIdx = from;
		int maxRightIdx = to;
		int sum = 0;
		int maxLeftSum = Integer.MIN_VALUE;
		int maxRightSum = Integer.MIN_VALUE;
		final int[] result = new int[3];

		// calculate left part (of mid)
		for (int i = mid; i >= from; i--) {
			sum += a[i];
			if (maxLeftSum < sum) {
				maxLeftSum = sum;
				maxLeftIdx = i;
			}

		}

		// calculate the right part (of mid)
		sum = 0; // reset sum
		for (int j = mid + 1; j <= to; j++) {
			sum += a[j];
			if (maxRightSum < sum) {
				maxRightSum = sum;
				maxRightIdx = j;
			}
		}
		result[0] = maxLeftIdx;
		result[1] = maxRightIdx;
		result[2] = maxLeftSum + maxRightSum;
		return result;
	}
}
