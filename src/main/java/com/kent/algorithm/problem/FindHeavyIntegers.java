package com.kent.algorithm.problem;

import com.kent.algorithm.Problem;
import com.kent.util.AlgUtil;

/**
 * <p>
 * A non-negative integer is called heavy if the average value of its digits in decimal representation exceeds 7. For example the number 8698 is
 * heavy, because the average value of its digits equal to (8+6+9+8)/4 = 7.75
 * </p>
 * 
 * <p>
 * Given two non-negative integers A and B find the number of heavy integers in the interval [A..B] (A and B included)
 * </p>
 * 
 * <p>
 * A and B are integers within the range [0..200,000,000].
 * </p>
 * 
 * <p>
 * This algorithm is to skip the numbers which are guaranteed to give a sub-average value. If sumDigits is the sum of the digits and numDigits is the
 * number of digits, then if sumDigits <= 7 * numDigits, we skip it and we need at least (7 * numDigits)-sumDigits+1 to bring the digits avg above
 * 7.0. The trick is to increment the number (starting from the units place) so that the total average goes above 7.0; To take an example, if the
 * number is 10000, sumDigits = 1 and avg of digits = 0.2. The deficit in sum is 7*5-1 +1= 35, so we can increment 10000 by 8999 i.e we increase the
 * sum by 8+9+9+9 = 35 and new number = 18999 has sumDigits =36 and average of digits becomes greater than 7.0; <br/>
 * <br/>
 * the average is not needed to be calculated at all.
 * </p>
 * 
 * <h2>some examples:</h2>
 * 
 * <pre>
 * heavy numbers between 1 and 100
 * 8 9 69 78 79 87 88 89 96 97 98 99
 * 
 * <b>brute-force way:</b>
 * calculate 100 times
 * 
 * <b>with this algorithm:</b>
 * calculate 18 times.
 * 
 * 
 * heavy numbers between 10000 and 20000
 * 18999 19899 19989 19998 19999
 * 
 * <b>brute-force way:</b>
 * calculate 10001 times
 * 
 * <b>with this algorithm:</b>
 * calculate 10 times.
 * </pre>
 */
public class FindHeavyIntegers extends Problem<int[], int[]> {

	/** The HEAV y_ threshold. */
	private static int HEAVY_THRESHOLD = 7;

	/** {@inheritDoc} */
	@Override
	public String getBigO() {
		return "unknown";
	}

	/** {@inheritDoc} */
	@Override
	public int[] solve(int[] input) {
		int a = input[0];
		final int b = input[1];
		int[] result = new int[] {};
		int digSum;
		int reqSum;
		int d; // how many digits
		final int dv;
		while (a <= b) {

			digSum = 0;
			d = 0;
			int n = a;
			// calculate the integer has how many digits and the sum of all digits
			while (n != 0) {
				digSum += n % 10;
				d++;
				n /= 10;
			}

			reqSum = d * HEAVY_THRESHOLD + 1;
			if (digSum < reqSum) {
				a += getIncrement(a, reqSum - digSum);
			} else { // heavy integer
				result = AlgUtil.appendIntArray(result, a);
				a++;
			}
		}

		return result;
	}

	/**
	 * Gets the increment.
	 * 
	 * @param n
	 *            the n, the integer below AVG
	 * @param deficit
	 *            the deficit to required sum of digits
	 * @return the increment
	 */
	private int getIncrement(int n, int deficit) {
		int incr = 0;
		int d = 1; // the digit flag 1, 10, 100, 1000...
		int t = n;
		int dv = 0;
		while (deficit > 0) {
			dv = t % 10;
			if (dv < 9) {
				final int incrD = dv < deficit ? 9 - dv : deficit;
				incr += incrD * d;
				deficit -= incrD;
				incr += deficit < 0 ? deficit * d : 0;
			}
			d *= 10;
			t /= 10;
		}
		return incr;
	}

}
