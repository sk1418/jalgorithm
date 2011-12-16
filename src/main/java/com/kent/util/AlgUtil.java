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
	public static void swap(final int[] data, final int i, final int j) {
		final int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;

	}

	/**
	 * get a random int[] array.
	 * 
	 * @param len
	 *            the length of the array
	 * @param max
	 *            the max element of the array
	 * @param allowNegative
	 *            if the array allows negative element
	 * @return the array
	 */
	public static int[] getRandomIntArray(final int len, final int max, final boolean allowNegative) {
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

	/**
	 * Adds the int to array.
	 * 
	 * extend the int[] array and append the int value to the array.
	 * 
	 * @param a
	 *            the a the array needs to be inserted
	 * @param v
	 *            the v
	 * @return the int[] the new array object with the given v at the end
	 */
	public static synchronized int[] addIntToArray(final int[] a, final int v) {
		if (a == null) {
			return a;
		}
		final int l = a.length + 1;
		final int[] newA = Arrays.copyOf(a, l);
		newA[l - 1] = v;
		return newA;
	}

	public static void printIntArray(final int[] a) {
		print(Arrays.toString(a));
	}

	/**
	 * Line separator.
	 * 
	 * @param s
	 *            the string need to be repeated
	 * @param times
	 *            the times
	 * @return the string
	 */
	public static String repeatString(final String s, final int times) {
		final StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= times; i++) {
			sb.append(s);
		}
		return sb.toString();
	}

	/**
	 * Prints the text
	 * 
	 * @param text
	 *            the text
	 */
	public static void print(final String text) {
		System.out.println(text);
	}

	/**
	 * Append newline.
	 * 
	 * @param sb
	 *            the sb
	 * @param text
	 *            the text
	 */
	public static void appendNewline(final StringBuffer sb, final String text) {
		if (sb != null) {
			sb.append(text).append("\n");
		}
	}

	/**
	 * simulating the clear command. this method print 25 "\n"s.
	 * 
	 * <pre>
	 * System.out.print((char) 27 + &quot;[2J&quot;);
	 * </pre>
	 * 
	 * works for linux console, however Windows NT console may not support it.
	 */
	public static void clear() {
		final char[] c = new char[25];
		Arrays.fill(c, '\n');
		// System.out.print((char) 27 + "[2J");
		print(String.copyValueOf(c));
	}
}
