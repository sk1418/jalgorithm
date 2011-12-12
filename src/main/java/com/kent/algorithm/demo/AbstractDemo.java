package com.kent.algorithm.demo;

import com.kent.util.AlgUtil;
import com.kent.util.Stopwatch;

/**
 * The Class AbstractDemo.
 */
public abstract class AbstractDemo {

	/** The Big array size, used by demo classes. */
	protected final int BIG_ARRAY_SIZE = 30000;

	/** The Small array size, used by demo classes */
	protected final int SMALL_ARRAY_SIZE = 14;

	/** The stopwatch. */
	protected Stopwatch stopwatch = new Stopwatch();

	/**
	 * Do demo.
	 */
	public final void doDemo() {
		prepareDemo();
		print("Warming JVM up....");
		// warming up
		for (int x = 3; x > 0; x--) {
			print(x + "...");
			warmingUp();
		}
		print("Done\n");
		print(AlgUtil.lineSeparator('#', 70));
		printDescription();
		print(AlgUtil.lineSeparator('#', 70));
		print("");
		print("");
		specificDemo();
	}

	/**
	 * for a stopwatch micro-benchmark, JVM has sometime JIT problem.
	 * 
	 * warmingUp is trying to avoid the JIT effects.
	 * 
	 * if warmingUp phase is not necessary, just leave an empty impl. in sub-class
	 */
	protected abstract void warmingUp();

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
	protected final void print(final String text) {
		System.out.println(text);
	}

	protected abstract void printDescription();
}
