package com.kent.algorithm.demo;

import com.kent.util.Stopwatch;

/**
 * The Class AbstractDemo.
 */
public abstract class AbstractDemo {

	/** The Big array size, used by demo classes. */
	protected final int BIG_ARRAY_SIZE = 20000;

	/** The Small array size, used by demo classes */
	protected final int SMALL_ARRAY_SIZE = 14;

	/** The stopwatch. */
	protected Stopwatch stopwatch = new Stopwatch();

	/**
	 * Do demo.
	 */
	public final void doDemo() {
		prepareDemo();
		specificDemo();
	}

	/**
	 * Prepare demo.
	 */
	protected abstract void prepareDemo();

	/**
	 * Specific demo.
	 */
	protected abstract void specificDemo();

	/**
	 * Prints the info.
	 * 
	 * @param text
	 *            the text
	 */
	protected final void printInfo(final String text) {
		System.out.println(text);
	}
}
