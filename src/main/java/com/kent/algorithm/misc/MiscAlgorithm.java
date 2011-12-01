package com.kent.algorithm.misc;

import org.apache.log4j.Logger;

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

	private static final Logger LOG = Logger.getLogger(MiscAlgorithm.class);

	/**
	 * Execute.
	 * 
	 * @param dara
	 *            the dara
	 * @return the t
	 */
	abstract public T execute(E data);

}
