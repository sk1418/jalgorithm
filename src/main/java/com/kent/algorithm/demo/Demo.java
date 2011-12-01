package com.kent.algorithm.demo;

import com.kent.util.Stopwatch;

public abstract class Demo {

	protected Stopwatch stopwatch = new Stopwatch();

	final public void doDemo() {
		prepareDemo();
		specificDemo();
	}

	abstract protected void prepareDemo();

	abstract protected void specificDemo();
}
