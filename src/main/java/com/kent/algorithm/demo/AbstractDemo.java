package com.kent.algorithm.demo;

import com.kent.util.AlgUtil;
import com.kent.util.Stopwatch;

/**
 * The Class AbstractDemo.
 */
public abstract class AbstractDemo {
	/** The Constant SPLT. */
	protected static final String SPLT = AlgUtil.repeatString("=", 70);
	/** The Big array size, used by demo classes. */
	protected static final int BIG_ARRAY_SIZE = 30000;

	/** The Small array size, used by demo classes */
	protected static final int SMALL_ARRAY_SIZE = 14;

	protected static final int WARMING_UP_LOOPS = 3;
	/** The stopwatch. */
	protected Stopwatch stopwatch = new Stopwatch();

	/**
	 * Do demo.
	 */
	public final void doDemo() {
		prepareDemo();
		print("Warming JVM up....");
		// warming up
		for (int x = WARMING_UP_LOOPS; x > 0; x--) {
			print(x + "...");
			warmingUp();
		}
		print("Done\n\n");
		printLine("#", 0);
		print(demoDescription());
		printLine("#", 0);
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


	protected final void printf(final String format, Object...args) {
		System.out.printf(format, args);
	}

	/**
	 * print a line composed by give c character, length len
	 * @param c
	 * @param len take the default length (70) if less then 1
	 */
	protected final void printLine(String c, int len) {
		len = len<=0? 70:len;
		print(AlgUtil.repeatString(c,len));
	}
	protected abstract String demoDescription();
}
