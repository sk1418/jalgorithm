package com.kent.algorithm.demo.problem;

import java.util.Arrays;

import org.apache.log4j.Logger;

import com.kent.algorithm.demo.Demo;
import com.kent.algorithm.problem.CountInversionPairs;
import com.kent.util.AlgUtil;


public class CountInversionPairsDemo  extends Demo{

	private static final Logger LOG = Logger
			.getLogger(CountInversionPairsDemo.class);
	private int[] smallArray;

	private int[] bigArray;


	private CountInversionPairs problem ;


	@Override
	protected void prepareDemo() {
		smallArray = AlgUtil.getRandomIntArray(SMALL_ARRAY_SIZE, 5*SMALL_ARRAY_SIZE);
		bigArray = AlgUtil.getRandomIntArray(BIG_ARRAY_SIZE, 5*BIG_ARRAY_SIZE);
		problem =  new CountInversionPairs();
	}

	@Override
	protected void specificDemo() {
		printInfo(String.format("Counting inversion pairs algorithm with %s complexity\n", problem.getBigO()));
		doJob(bigArray);
		doJob(smallArray);

	}

	private void doJob(int[] a){
		printInfo("array with "+ a.length + " elements:");
		if(a.length == SMALL_ARRAY_SIZE){
			LOG.info("Array: " + Arrays.toString(a));
		}
		printInfo(AlgUtil.lineSeparator('=', 50));
		long c = 0;
		stopwatch.start();
		c = problem.solve(a);
		stopwatch.stop();
		printInfo(String.format("Count of inversion pairs: %s (%s ms)\n",  c, stopwatch.read()));
		stopwatch.reset();
	}


	public static void main(String[] args) {
		Demo demo = new CountInversionPairsDemo();
		demo.doDemo();
	}
}

