package com.kent.algorithm;

public interface Algorithm<I, T> {
	String getBigO();

	T execute(I input);

}
