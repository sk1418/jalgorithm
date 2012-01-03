package com.kent.algorithm;

public abstract class Sorting implements Algorithm<int[], int[]> {
	private boolean printSteps = false;

	/**
	 * For <b>Comparison Sorts</b>, the same array object would be sorted and returned (In fact returning is not necessary). For Linear Time Sorting,
	 * the returned sorted array is a new object
	 * 
	 * @param data
	 *            , the array needs to be sorted
	 * @return sorted array
	 */
	public abstract int[] sort(int[] data);

	@Override
	public int[] execute(int[] input) {
		return sort(input);
	}

	public boolean isPrintSteps() {
		return printSteps;
	}

	public void setPrintSteps(boolean printSteps) {
		this.printSteps = printSteps;
	}

}
