package com.kent.algorithm;

public abstract class Sorting implements Algorithm<int[], int[]> {
	private boolean printSteps = false;

	public abstract void sort(int[] data);

	@Override
	public int[] execute(int[] input) {
		sort(input);
		return input;
	}

	public boolean isPrintSteps() {
		return printSteps;
	}

	public void setPrintSteps(boolean printSteps) {
		this.printSteps = printSteps;
	}

}
