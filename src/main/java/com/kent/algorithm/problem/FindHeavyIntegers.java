package com.kent.algorithm.problem;

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
 * The trick is to skip the numbers which are guaranteed to give a sub-average value. If sumDigits is the sum of the digits and numDigits is the
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

	/** {@inheritDoc} */
	@Override
	public String getBigO() {
		return "unknown";
	}

	/** {@inheritDoc} */
	@Override
	public int[] solve(int[] input) {
		final int a = input[0];
		final int b = input[1];

		return null;
	}

	/** {@inheritDoc} */
	@Override
	protected StringBuffer getDescription() {
		final StringBuffer sb = new StringBuffer();
		AlgUtil.appendNewline(sb, "Finding Heavy integers:");
		AlgUtil.appendNewline(sb, "A non-negative integer is called heavy if the average value of its digits in decimal representation");
		AlgUtil.appendNewline(sb, "exceeds 7. For example the number 8698 is heavy, because the average value of its digits equal to");
		AlgUtil.appendNewline(sb, "(8+6+9+8)/4 = 7.75");
		AlgUtil.appendNewline(sb, "");
		AlgUtil.appendNewline(sb, "Given two non-negative integers A and B find the number of heavy integers ");
		AlgUtil.appendNewline(sb, "in the interval [A..B] (A and B included),A and B are integers within the range [0..200,000,000].");
		AlgUtil.appendNewline(sb, "");
		AlgUtil.appendNewline(sb, "The trick is to skip the numbers which are guaranteed to give a sub-average value. ");
		AlgUtil.appendNewline(sb, "If sumDigits is the sum of the digits and numDigits is the number of digits, then ");
		AlgUtil.appendNewline(sb, "if sumDigits <= 7 * numDigits, we skip it and we need at least ");
		AlgUtil.appendNewline(sb, "(7 * numDigits)-sumDigits+1 to bring the digits avg above 7.0. The trick is to ");
		AlgUtil.appendNewline(sb, "increment the number (starting from the units place) so that the total average goes ");
		AlgUtil.appendNewline(sb, "above 7.0; To take an example, if the number is 10000, sumDigits = 1 and avg of ");
		AlgUtil.appendNewline(sb, "digits = 0.2. The deficit in sum is 7*5-1 +1= 35, so we can increment 10000 by 8999 ");
		AlgUtil.appendNewline(sb, "i.e we increase the sum by 8+9+9+9 = 35 and new number = 18999 has sumDigits =36 ");
		AlgUtil.appendNewline(sb, "and average of digits becomes greater than 7.0");

		return sb;
	}

}
