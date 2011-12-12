package com.kent.algorithm;

public abstract class Sorting implements Algorithm {

	public abstract void sort(int[] data);

	@Override
	public StringBuffer getDescription() {
		return new StringBuffer();
	}

}
