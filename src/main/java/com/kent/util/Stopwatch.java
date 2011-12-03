package com.kent.util;

import java.math.BigDecimal;

/**
 * The Class StopWatch.
 */
public class Stopwatch {

	/** The running. */
	private boolean running;

	/** The start time. */
	private long startTime;

	/** The elapsed millisec. */
	private long elapsedNanoSec;

	/**
	 * Start the stopwatch
	 */
	public void start() {
		if (!running) {
			this.startTime = System.nanoTime();
			running = true;
		} else {
			throw new IllegalStateException("the stopwatch is already running");
		}
	}

	/**
	 * Stop the stopwatch.
	 */
	public void stop() {
		if (running) {
			elapsedNanoSec = System.nanoTime() - startTime;
			running = false;
		} else {
			throw new IllegalStateException("the stopwatch is not running");
		}
	}

	/**
	 * reset the stopwatch, elapsedTime will be set to 0, start time will be set to current timestamp status will be kept.
	 */
	public void reset() {
		elapsedNanoSec = 0;

	}

	/**
	 * Read.
	 * 
	 * @return the long
	 */
	public BigDecimal read() {
		final BigDecimal b = new BigDecimal(readInNano());
		return b.divide(new BigDecimal("1000000"), 1, BigDecimal.ROUND_HALF_UP);
	}

	public long readInNano() {
		if (running) {
			elapsedNanoSec = System.nanoTime() - startTime;
		}
		return this.elapsedNanoSec;
	}

	/**
	 * Read in string.
	 * 
	 * @return the string
	 */
	public String readAsString() {
		return "Elapsed " + this.read() + " ms.";
	}
}
