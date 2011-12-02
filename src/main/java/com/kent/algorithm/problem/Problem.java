package com.kent.algorithm.problem;

import com.kent.algorithm.Algorithm;

/**
 * The Class MiscAlgorithm.
 * 
 * @param <E>
 *            the element type
 * @param <T>
 *            the generic type
 */
public abstract class Problem<E, T> implements Algorithm {

	/**
	 * Execute.
	 * 
	 * @param data
	 *            the dara
	 * @return the t
	 */
	abstract public T solve(E data);

}
