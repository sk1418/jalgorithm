package com.kent.util;

import java.util.Random;

public class Util {

    private Util() {
	throw new RuntimeException("Util class cannot be instantiated.");
    }

    /**
     * helper method, swap the two element in an int array.
     * 
     * @param data
     *            , the int array
     * @param i
     *            index i
     * @param j
     *            index j
     */
    public static void swap(int[] data, int i, int j) {
	int tmp = data[i];
	data[i] = data[j];
	data[j] = tmp;

    }

    /**
     * get a random int array.
     * 
     * @param len
     *            length of the array
     * @param max
     *            max integer
     * @return random int array
     */
    public static int[] getRandomIntArray(int len, int max) {
	int[] intArray = new int[len];
	Random rand = new Random();
	rand.setSeed(System.currentTimeMillis());
	for (int i = 0; i < intArray.length; i++)
	    intArray[i] = rand.nextInt(max);

	return intArray;
    }

}
