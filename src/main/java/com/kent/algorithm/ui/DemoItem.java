package com.kent.algorithm.ui;

import com.kent.algorithm.demo.AbstractDemo;

/**
 * @author: Kent
 * Created on 2014-08-10.
 */
public class DemoItem {
	private String name;
	private Class<? extends AbstractDemo> demoClass;
	private int index;
	private DemoType demoType;

	public DemoItem(int index, String name, DemoType demoType, Class<? extends AbstractDemo> demoClass) {
		this.name = name;
		this.index = index;
		this.demoType = demoType;
		this.demoClass = demoClass;
	}

	public int getIndex() {
		return index;
	}

	public String getName() {
		return name;
	}

	public Class<? extends AbstractDemo> getDemoClass() {
		return demoClass;
	}

	public DemoType getDemoType() {
		return demoType;
	}
}
