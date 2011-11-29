package com.kent.algorithm.misc;

public abstract class MiscAlgorithm<E, T> {
	protected String name;

	abstract public T execute(E dara);

	abstract public String output();
}
