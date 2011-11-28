package com.kent.util;

/**
 * The Class StopWatch.
 */
public class Stopwatch {

    /** The running. */
    private boolean running;

    /** The start time. */
    private long startTime;

    /** The elapsed millisec. */
    private long elapsedMillisec;

    /**
     * Start the stopwatch
     */
    public void start() {
	if (!running) {
	    this.startTime = System.currentTimeMillis();
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
	    elapsedMillisec = System.currentTimeMillis() - startTime;
	    running = false;
	} else {
	    throw new IllegalStateException("the stopwatch is not running");
	}
    }

    /**
     * reset the stopwatch, elapsedTime will be set to 0, start time will be set to current timestamp
     * status will be kept.
     */
    public void reset() {
	elapsedMillisec = 0;

    }

    /**
     * Read.
     * 
     * @return the long
     */
    public long read() {
	if (running) {
	    elapsedMillisec = System.currentTimeMillis() - startTime;
	}
	return this.elapsedMillisec;
    }

    /**
     * Read in string.
     * 
     * @return the string
     */
    public String readInString() {
	return "Elapsed " + this.read() + " ms.";
    }
}
