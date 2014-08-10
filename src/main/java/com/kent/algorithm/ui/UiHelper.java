package com.kent.algorithm.ui;

import java.util.List;
import java.util.Set;

import org.reflections.Reflections;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ListMultimap;
import com.kent.util.AlgUtil;

/**
 * @author: Kent
 * Created on 2014-08-10.
 */
public class UiHelper {

	// the line format of two columns layout
	private static final String FORMAT = "%4s %-35s |%4s %-35s";
	// @formatter:off
	//menu layout, define the left/right block.
	private static final ImmutableListMultimap<Integer, DemoType> MENU_LAYOUT =
			ImmutableListMultimap.<Integer, DemoType>builder()
					.putAll(1, DemoType.CompSort, DemoType.LinearSort)
							//			.putAll(2, DemoType.Test)
					.putAll(2, DemoType.LinkedList)
							//			.putAll(4, DemoType.Test)
					.putAll(3, DemoType.Problems)
					.build();
	//@formatter: on

	/**
	 * generate a multimap, to represent the demos need to be displayed on UI.
	 * The key is the {@link DemoType}, the value is a list of {@link DemoItem}
	 *
	 * @return the MultiMap
	 */
	public static ListMultimap<DemoType,DemoItem> getDemoMap() {
		ListMultimap<DemoType, DemoItem> demoMap = ArrayListMultimap.create();
		Reflections reflections = new Reflections("com.kent.algorithm.demo");

		Set<Class<?>> demoClasses = reflections.getTypesAnnotatedWith(Demo.class);

		Demo demoAnnotation = null;
		for (Class cls : demoClasses) {
			demoAnnotation = (Demo) cls.getAnnotation(Demo.class);
			DemoType demoType = demoAnnotation.type();
			demoMap.put(demoType, new DemoItem(demoType.nextIdx(), demoAnnotation.name(), demoType, cls));
		}
		return demoMap;
	}

	public static void printMenu(ListMultimap<DemoType, DemoItem> demoMap) {
		final int rows = MENU_LAYOUT.keySet().size();
		final DemoType type = null;
		for (int row = 1; row <= rows; row++) {
			AlgUtil.println(AlgUtil.repeatString("=", 77));
			if (MENU_LAYOUT.get(row).size() == 1) {
				printSingleColMenu(MENU_LAYOUT.get(row).get(0), demoMap);
			} else {
				printDoubleColMenu(MENU_LAYOUT.get(row), demoMap);
			}
		}
	}




	private static void printSingleColMenu(final DemoType type, ListMultimap<DemoType, DemoItem> demoMap) {
		final List<DemoItem> items = demoMap.get(type);
		AlgUtil.println(type.desc);

		final int size = items.size();
		// if it is just a marker/separator, return
		if (size == 0) {
			return;
		}
		AlgUtil.println(AlgUtil.repeatString("_", 77));
		final int rows = size % 2 == 0 ? size / 2 : size / 2 + 1;
		DemoItem iteml = null;
		DemoItem itemr = null;
		for (int i = 0; i < rows; i++) {
			iteml = items.get(i);
			itemr = i + rows < size ? items.get(i + rows) : null;
			if (itemr != null) {
				AlgUtil.println(String.format(FORMAT, iteml.getIndex(), iteml, itemr.getIndex(), itemr));
			}
			else {
				AlgUtil.println(String.format(FORMAT, iteml.getIndex(), iteml, "", ""));
			}
		}

	}

	private static void printDoubleColMenu(final List<DemoType> type, ListMultimap<DemoType, DemoItem> demoMap) {
		assert type.size() == 2;
		final List<DemoItem> itemsl = demoMap.get(type.get((0)));
		final List<DemoItem> itemsr = demoMap.get(type.get((1)));
		final int rows = itemsl.size() > itemsr.size() ? itemsl.size() : itemsr.size();
		DemoItem iteml = null;
		DemoItem itemr = null;

		AlgUtil.println(String.format("%-40s |%-40s", type.get(0).desc, type.get(1).desc));
		AlgUtil.println(AlgUtil.repeatString("_", 77));
		for (int i = 0; i < rows; i++) {
			itemr = i < itemsr.size() ? itemsr.get(i) : null;
			iteml = i < itemsl.size() ? itemsl.get(i) : null;
			if (iteml == null) {
				AlgUtil.println(String.format(FORMAT, "", "", itemr.getIndex(), itemr));
			} else if (itemr == null) {
				AlgUtil.println(String.format(FORMAT, iteml.getIndex(), iteml, "", ""));
			} else {
				AlgUtil.println(String.format(FORMAT, iteml.getIndex(), iteml, itemr.getIndex(), itemr));
			}

		}

	}
}
