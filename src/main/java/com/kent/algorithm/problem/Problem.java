package com.kent.algorithm.problem;

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
public abstract class Problem<E, T> {

	private static final Logger LOG = Logger.getLogger(Problem.class);

	/**
	 * Execute.
	 * 
	 * @param dara
	 *            the dara
	 * @return the t
	 */
	abstract public T solve(E data);

}
