package com.kent.algorithm;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.omg.PortableInterceptor.DISCARDING;
import org.reflections.Reflections;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Maps;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoItem;
import com.kent.algorithm.ui.DemoType;
import com.kent.algorithm.ui.UiHelper;
import com.kent.util.AlgUtil;

public class AlgorithmDemo {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {


		Scanner scanner;
		int input = -9;
		String tmp;
		scanner = new Scanner(System.in);
		final ListMultimap<DemoType, DemoItem> demoMap = UiHelper.getDemoMap();
		//build the map for menu
		final Map<Integer, DemoItem> menuMap = Maps.newHashMap();
		for (DemoItem item : demoMap.values()) {
			menuMap.put(item.getIndex(), item);
		}


		// init
		while (input != 0) {
			try {

				AlgUtil.println(AlgUtil.repeatString("\n", 3));
				AlgUtil.println("Available Demos:");
				// AlgUtil.println(getDemoTypePrintList());
				UiHelper.printMenu(demoMap);
				AlgUtil.println(AlgUtil.repeatString("=", 77));
				if (input == -9) {

					AlgUtil.println("select the demo index (press 0 to exit):");
				} else if (!menuMap.containsKey(input)) {
					AlgUtil.println("unknown demo index, please input a valid demo index (0 to exit):");
				}
				tmp = scanner.nextLine();
				input = Integer.valueOf(tmp);
				if (input == 0) {
					break;
				}
				if (menuMap.containsKey(input)) {
					final AbstractDemo demo = menuMap.get(input).getDemoClass().newInstance();
					AlgUtil.println(AlgUtil.repeatString("\n", 2));
					AlgUtil.clear();
					AlgUtil.println("[ " + menuMap.get(input).getName() + " ]\n");
					demo.doDemo();
					AlgUtil.println("\n" + AlgUtil.repeatString("=", 49));
					AlgUtil.println("Press [Enter] to continue... ");
					tmp = scanner.nextLine();
					input = -9;
				}
			} catch (final Exception e) {
				e.printStackTrace();
				input = -1;
			}
		}

		AlgUtil.println("exiting...");
		scanner.close();
		System.exit(0);
	}



}
