package com.kent.algorithm;

public interface Algorithm<I, T> {
	String getBigO();

	T execute(I input);

	/**
	 * the flag, if print the step info. this method could be used by demo classes.
	 * 
	 * @return
	 */
	boolean printSteps();

}
