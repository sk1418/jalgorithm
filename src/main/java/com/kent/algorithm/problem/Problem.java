package com.kent.algorithm.problem;

import com.kent.algorithm.Algorithm;
import com.kent.util.AlgUtil;

// TODO: Auto-generated Javadoc
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
	 * Execute the implementation to solve the problem.
	 * 
	 * @param data
	 *            the dara
	 * @return the t
	 */
	public abstract T solve(E data);

	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	protected abstract StringBuffer getDescription();

	/**
	 * Prints the desc.
	 */
	public void printDesc() {
		AlgUtil.print(getDescription().toString());
	}

}
