package com.kent.algorithm.demo;

import com.kent.util.Stopwatch;

public abstract class Demo {

	protected final int BIG_ARRAY_SIZE = 20000;
	protected final int SMALL_ARRAY_SIZE = 14;
	
	protected Stopwatch stopwatch = new Stopwatch();

	final public void doDemo() {
		prepareDemo();
		specificDemo();
	}

	
	
	
	abstract protected void prepareDemo();

	abstract protected void specificDemo();
	
	protected final void printInfo(String text){
		System.out.println(text);
	}
}
