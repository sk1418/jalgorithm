package com.kent.algorithm;

/**
 * The Interface Algorithm.
 * 
 * @param <I>
 *            the input type
 * @param <T>
 *            the output type
 */
public interface Algorithm<I, T> {

	/**
	 * Gets the big o.
	 * 
	 * @return the big o
	 */
	String getBigO();

	/**
	 * Execute.
	 * 
	 * @param input
	 *            the input
	 * @return the t
	 */
	T execute(I input);

	/**
	 * the flag, if print the step info. this method could be used by demo classes.
	 * 
	 * @return true, if successful
	 */
	boolean printSteps();

}
