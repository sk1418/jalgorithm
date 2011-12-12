package com.kent.util;

import java.util.Arrays;
import java.util.Random;

/**
 * The Class AlgUtil.
 * 
 * some utility methods
 */
public final class AlgUtil {

	/**
	 * Instantiates a new alg util.
	 */
	private AlgUtil() {
		throw new RuntimeException("Util class cannot be instantiated.");
	}

	/**
	 * helper method, swap the two element in an int array.
	 * 
	 * @param data
	 *            , the int array
	 * @param i
	 *            index i
	 * @param j
	 *            index j
	 */
	public static void swap(int[] data, int i, int j) {
		final int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;

	}

	/**
	 * get a random int[] array
	 * 
	 * @param len
	 *            the length of the array
	 * @param max
	 *            the max element of the array
	 * @param allowNegative
	 *            if the array allows negative element
	 * @return the array
	 */
	public static int[] getRandomIntArray(final int len, final int max, boolean allowNegative) {
		final int[] intArray = new int[len];
		final Random rand = new Random();
		rand.setSeed(181402);

		if (!allowNegative) {
			if (max <= 0) {
				throw new IllegalArgumentException("max must be possitive if allowNegative false");
			}
			for (int i = 0; i < intArray.length; i++) {
				intArray[i] = rand.nextInt(max);
			}
		} else {
			int n;
			int i = 0;
			while (i < len) {
				n = rand.nextInt() % max;
				if (max > 0) {
					if (Math.abs(n) < max) {
						intArray[i] = n;
						i++;
					}
				} else {
					intArray[i] = n;
					i++;
				}

			}
		}

		return intArray;
	}

	public static synchronized int[] addIntToArray(int[] a, int v) {
		final int l = a.length + 1;
		final int[] newA = Arrays.copyOf(a, l);
		newA[l - 1] = v;
		return newA;
	}

	/**
	 * Line separator.
	 * 
	 * @param c
	 *            the c
	 * @param times
	 *            the times
	 * @return the string
	 */
	public static String lineSeparator(final char c, final int times) {
		final StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= times; i++) {
			sb.append(c);
		}
		return sb.toString();
	}

	public static void print(final String text) {
		System.out.println(text);
	}

	public static void appendNewline(StringBuffer sb, String text) {
		if (sb != null) {
			sb.append(text).append("\n");
		}
	}
}
