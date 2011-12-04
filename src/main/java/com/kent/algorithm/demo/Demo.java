package com.kent.algorithm.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.kent.algorithm.demo.problem.CountInversionPairsDemo;
import com.kent.algorithm.demo.problem.MaxSubArrayDemo;
import com.kent.util.AlgUtil;

public class Demo {

	private static Map<Integer, Class> demoTypeMap = new HashMap<Integer, Class>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AlgUtil.print("Available Demos:");
		AlgUtil.print(AlgUtil.lineSeparator('=', 70));
		AlgUtil.print(getDemoTypePrintList());
		AlgUtil.print(AlgUtil.lineSeparator('=', 70));
		AlgUtil.print("select the demo index (press 0 to exit):");
		Scanner scanner;
		int input = -1;
		String tmp;
		boolean init = true;
		scanner = new Scanner(System.in);
		while (!demoTypeMap.containsKey(input) && input != 0) {
			try {
				if (!init) {
					AlgUtil.print(AlgUtil.lineSeparator('=', 70));
					AlgUtil.print(getDemoTypePrintList());
					AlgUtil.print(AlgUtil.lineSeparator('=', 70));
					AlgUtil.print("unknow demo index, please input a valid demo index (0 to exit):");
				}
				init = false;
				tmp = scanner.nextLine();
				input = Integer.valueOf(tmp);

			} catch (final Exception e) {
				input = -1;
			} finally {

			}
		}
		if (input == 0) {
			AlgUtil.print("exiting...");
			System.exit(0);
		} else {

			try {
				final AbstractDemo demo = (AbstractDemo) demoTypeMap.get(input).newInstance();
				demo.doDemo();
			} catch (final InstantiationException e) {
				e.printStackTrace();
			} catch (final IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	private static String getDemoTypePrintList() {
		demoTypeMap.clear();
		final String format = "%-35s %s %s";
		final StringBuffer sb = new StringBuffer();
		for (final DemoType type : DemoType.values()) {
			sb.append(String.format(format, type, AlgUtil.lineSeparator('.', 30), type.getIdx()));
			sb.append("\n");
			demoTypeMap.put(type.getIdx(), type.getDemoClass());
		}
		return sb.toString();
	}

	enum DemoType {
		//@formatter:off
		Sorting(1, SortingDemo.class), 
		Problem_MaxSubArray(2, MaxSubArrayDemo.class), 
		Problem_CountInversionPairs(3, CountInversionPairsDemo.class);
		//@formatter:on
		int idx;
		Class demoClass;

		DemoType(int idx, Class demoClass) {
			this.idx = idx;
			this.demoClass = demoClass;
		}

		public int getIdx() {
			return idx;
		}

		public Class getDemoClass() {
			return demoClass;
		}

	}

}
