package com.kent.algorithm.sorting;

public abstract class Sorting {
    protected String name;

    public abstract void sort(int[] data);

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

}
