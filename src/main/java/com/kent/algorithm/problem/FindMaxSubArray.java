package com.kent.algorithm.problem;

import org.apache.log4j.Logger;

import com.kent.util.AlgUtil;

/**
 * find the nonempty, contiguous subarray of given array, whose values have the largest sum.
 * 
 * 
 * <p>
 * using <b>divide and conquer</b> way to solve the problem.
 * <ul>
 * <li>the maxSubarray can entirely in the subarray A[low .. mid]</li>
 * <li>entirely in the subarray A[mid+1 .. high]</li>
 * <li>crossing the midpoint: ..i.. (maxSumLeft) ... <-mid -> .(maxSumRight)..j...</li>
 * </ul>
 * </p>
 * <b>Time Complexity</b>: O(nlogn)
 * 
 * @author kent
 * 
 */
public class FindMaxSubArray extends Problem<int[], int[]> {

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(FindMaxSubArray.class);

	/** The array. */
	private int[] array = null;

	/** The start. */
	private int start = 0;

	/** The end. */
	private int end = 0;

	/** The max sum. */
	private int maxSum = Integer.MIN_VALUE;

	/** {@inheritDoc} */
	@Override
	public String getBigO() {
		return "O(nlog(n))";
	}

	/**
	 * find the maxSubArray (the subMaxArray of @para data, which have max sum of all elements).
	 * 
	 * @param data
	 *            the array
	 * @return a tuple int[3]={startIdx, endIdx, maxSum}
	 */
	@Override
	public int[] solve(final int[] data) {
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

	/**
	 * Find max sub array.
	 * 
	 * @param a
	 *            the a
	 * @param from
	 *            the from
	 * @param to
	 *            the to
	 * @return the int[]
	 */
	private int[] findMaxSubArray(final int[] a, final int from, final int to) {
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

	/**
	 * Find max crossing sub array.
	 * 
	 * @param a
	 *            the a
	 * @param from
	 *            the from
	 * @param mid
	 *            the mid
	 * @param to
	 *            the to
	 * @return the int[]
	 */
	private int[] findMaxCrossingSubArray(final int[] a, final int from, final int mid, final int to) {
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

	@Override
	public StringBuffer getDescription() {
		final StringBuffer sb = new StringBuffer();
		AlgUtil.appendNewline(sb, "Finding Max Subarray problem:");
		AlgUtil.appendNewline(sb, "Find the nonempty, contiguous subarray of given array, whose values have the largest sum.");
		AlgUtil.appendNewline(sb, "");
		AlgUtil.appendNewline(sb, "Using Divide And Conquer way to solve the problem:");
		AlgUtil.appendNewline(sb, "");
		AlgUtil.appendNewline(sb, "- the maxSubarray can entirely in the subarray A[low .. mid]");
		AlgUtil.appendNewline(sb, "- entirely in the subarray A[mid+1 .. high]");
		AlgUtil.appendNewline(sb, "- crossing the midpoint: ..i.. (maxSumLeft) ... <-mid -> .(maxSumRight)..j...");

		return sb;
	}
}
