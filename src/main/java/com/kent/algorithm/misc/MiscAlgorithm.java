package com.kent.algorithm.misc;

// TODO: Auto-generated Javadoc
/**
 * The Class MiscAlgorithm.
 * 
 * @param <E>
 *            the element type
 * @param <T>
 *            the generic type
 */
public abstract class MiscAlgorithm<E, T> {

	/** The name. */
	protected String name;

	/**
	 * Execute.
	 * 
	 * @param dara
	 *            the dara
	 * @return the t
	 */
	abstract public T execute(E dara);

	/**
	 * Output.
	 * 
	 * @return the string
	 */
	abstract public String output();
}
