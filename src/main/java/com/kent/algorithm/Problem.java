package com.kent.algorithm;

/**
 * The Class MiscAlgorithm.
 * 
 * @param <I>
 *            the element type
 * @param <T>
 *            the generic type
 */
public abstract class Problem<I, T> implements Algorithm<I, T> {
	private boolean printSteps = false;

	/**
	 * Execute the implementation to solve the problem.
	 * 
	 * @param data
	 *            the dara
	 * @return the t
	 */
	public abstract T solve(I data);

	@Override
	public T execute(I input) {
		return solve(input);
	}

	@Override
	public boolean printSteps() {
		return printSteps;
	}

	public void setPrintSteps(boolean printSteps) {
		this.printSteps = printSteps;
	}

}
