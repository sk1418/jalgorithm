package com.kent.algorithm.demo.problem;

import com.google.common.base.Joiner;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.ReverseInteger;
import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoType;
import com.kent.util.AlgUtil;

@Demo(type = DemoType.Problems, name="Reverse Integer")
public class ReverseIntegerDemo extends AbstractDemo {

	/** The problem. */
	private ReverseInteger problem;
	private Integer input1;
	private Integer input2;

	@Override
	protected void prepareDemo() {
		input1 = 12345;
		input2 = -12345;
		problem = new ReverseInteger();
		problem.setPrintSteps(true);
	}

	@Override
	protected void specificDemo() {

		print("Time complexity:" + problem.getBigO());
		doJob(input1);
		doJob(input2);
	}

	@Override
	protected void warmingUp() {
		// warmingUp is not required
	}

	/**
	 * Do job.
	 * 
	 * @param a
	 *            the a
	 */
	private void doJob(final int a) {

		print("Int : " + a);
		print(AlgUtil.repeatString("=", 50));

		stopwatch.start();
		final int result = problem.solve(a);
		stopwatch.stop();
		print("Result: " + result);
		print(AlgUtil.repeatString("=", 50));
		print(stopwatch.readAsString());
		stopwatch.reset();
	}

	@Override
	protected void printDescription() {
		//@formatter:off
				final String d =Joiner.on("\n").join(
						"Reverse a given Integer:",
						"",
						"  Example1: x = 123, return 321",
						"  Example2: x = -123, return -321",
						"",
						"",
						"  If the integer's last digit is 0, what should the output be? ie, cases such",
						"  as 10, 100. Did you notice that the reversed integer might overflow?  Assume",
						"  the input is a 32-bit integer, then the reverse of 1000000003 overflows. How",
						"  should you handle such cases?",
						"  ",
						"  Throw an exception? Good, but what if throwing an exception is not an option?",
						"  You would then have to re-design the function (ie, add an extra parameter)."
						
						);
				//@formatter:on

		print(d);

	}
}
