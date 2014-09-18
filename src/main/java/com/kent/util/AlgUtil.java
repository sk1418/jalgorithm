package com.kent.util;

import com.kent.datastructure.MyTreeNode;

import java.util.Arrays;
import java.util.Random;

/**
 * The Class AlgUtil.
 * <p/>
 * some utility methods
 */
public final class AlgUtil {

    final static Random rand = new Random();

    /**
     * Instantiates a new alg util.
     */
    private AlgUtil() {
        throw new RuntimeException("Util class cannot be instantiated.");
    }

    /**
     * helper method, swap the two element in an int array.
     *
     * @param data , the int array
     * @param i    index i
     * @param j    index j
     */
    public static void swap(final int[] data, final int i, final int j) {
        final int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;

    }

    public static void swap(final char[] data, final int i, final int j) {
        final char tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;

    }

    public static int getRandomInRange(int min, int max) {
        return rand.nextInt(max - min + 1) + min;

    }

    /**
     * get a random int[] array.
     *
     * @param len           the length of the array
     * @param max           the max element of the array
     * @param allowNegative if the array allows negative element
     * @return the array
     */
    public static int[] getRandomIntArray(final int len, final int max, final boolean allowNegative) {
        final int[] intArray = new int[len];
        rand.setSeed(181402);

        if (!allowNegative) {
            if (max <= 0) {
                throw new IllegalArgumentException("max must be possitive if allowNegative false");
            }
            for (int i = 0; i < intArray.length; i++) {
                intArray[i] = rand.nextInt(max);
            }
        } else {
            int n;
            int i = 0;
            while (i < len) {
                n = rand.nextInt() % max;
                if (max > 0) {
                    if (Math.abs(n) < max) {
                        intArray[i] = n;
                        i++;
                    }
                } else {
                    intArray[i] = n;
                    i++;
                }

            }
        }

        return intArray;
    }

    /**
     * Adds the int to array.
     * <p/>
     * extend the int[] array and append the int value to the array.
     *
     * @param a the a the array needs to be inserted
     * @param v the v
     * @return the int[] the new array object with the given v at the end
     */
    public static synchronized int[] appendIntArray(final int[] a, final int v) {
        if (a == null) {
            return a;
        }
        final int l = a.length + 1;
        final int[] newA = Arrays.copyOf(a, l);
        newA[l - 1] = v;
        return newA;
    }

    public static synchronized String[] addStringToArray(final String[] a, final String v) {
        if (a == null) {
            return a;
        }
        final int l = a.length + 1;
        final String[] newA = Arrays.copyOf(a, l);
        newA[l - 1] = v;
        return newA;
    }

    /**
     * Prints the int array.
     *
     * @param a the a
     */
    public static void printIntArray(final int[] a) {
        println(Arrays.toString(a));
    }

    /**
     * prints the int array vertically
     *
     * @param a
     */
    public static void printIntArrayVertically(final int[] a) {
        for (final int x : a) {
            System.out.printf("%7d\n", x);
        }
    }

    /**
     * Line separator.
     *
     * @param s     the string need to be repeated
     * @param times the times
     * @return the string
     */
    public static String repeatString(final String s, final int times) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= times; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    /**
     * Prints the text.
     *
     * @param text the text
     */
    public static void println(final String text) {
        System.out.println(text);
    }

    /**
     * Prints the.
     *
     * @param text the text
     */
    public static void print(final String text) {
        System.out.print(text);
    }

    /**
     * Append newline.
     *
     * @param sb   the sb
     * @param text the text
     */
    public static void appendNewline(final StringBuffer sb, final String text) {
        if (sb != null) {
            sb.append(text).append("\n");
        }
    }

    /**
     * simulating the clear command. this method print 25 "\n"s.
     * <p/>
     * <pre>
     * System.out.print((char) 27 + &quot;[2J&quot;);
     * </pre>
     * <p/>
     * works for linux console, however Windows NT console may not support it.
     */
    public static void clear() {
        final char[] c = new char[25];
        Arrays.fill(c, '\n');
        // System.out.print((char) 27 + "[2J");
        println(String.copyValueOf(c));
    }


    final static String vfmt = "%s[ %s ]\n";
    final static String EmptyPH = repeatString(" ", 5) + "|";
    final static String NodePH = repeatString(" ", 5) + "|";
    final static String LastPH = repeatString(" ", 5) + "\\";

    public static <T> void printTreeNode(MyTreeNode<T> node) {
        _printTreeNode(node, "");
    }

    private static <T> void _printTreeNode(MyTreeNode<T> node, String pre) {
        String vStr = String.format(vfmt, pre + (pre.equals("") ? "" : "_ "), node.getValue());
        print(vStr);
        int size = node.getChildren().size();
        String npre;
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                pre = pre.replaceFirst("(\\\\)([| ]*)$", " $2");
                npre = pre + (pre.length() > 0 ? LastPH : EmptyPH);
            } else {
                npre = pre + (pre.length() > 0 ? NodePH : EmptyPH);
            }
            _printTreeNode(node.getChildren().get(i), npre);
        }
    }

    /**
     * Prints given array into Binary Tree format output
     *
     * @param a        the array
     * @param heapSize the heap size
     * @param flagIdx  the index of node, which needs to be highlighted
     */
    public static void printBinaryTree(int[] a, int heapSize, int flagIdx) {
        println("");
        if (heapSize == 2) {
            println("  " + a[0] + String.valueOf(flagIdx == 0 ? "*" : ""));
            println("  |");
            println("  " + a[1] + String.valueOf(flagIdx == 1 ? "*" : ""));
            println("");
            return;
        }
        final int h = (int) (Math.log(heapSize - 1) / Math.log(2)); // height of the tree/heap
        int leadingBlanks = 2 << h; // leading spaces
        int startIdx;
        String fmt;
        StringBuffer sb;

        for (int i = 0; i <= h; i++) {
            if (i == 0) {
                startIdx = 0;
            } else {
                startIdx = (2 << i - 1) - 1;
            }
            print(repeatString(" ", leadingBlanks));
            final int distance = 2 * leadingBlanks;

            int count = i == 0 ? 1 : 2 << i - 1;
            int count2 = count;
            fmt = "%-" + distance + "s";
            while (count > 0 && startIdx < heapSize) {
                final String node = String.valueOf(a[startIdx]) + (startIdx == flagIdx ? "*" : "");
                print(String.format(fmt, node));
                startIdx++;
                count--;
            }
            println("");

            // print node connections
            if (i != h) {
                print(repeatString(" ", leadingBlanks / 2 + 1));
                fmt = "%-" + distance / 2 + "s";
                while (count2 > 0) {
                    sb = new StringBuffer();
                    sb.append("/");
                    if (distance / 2 <= 4) {
                        sb.append(repeatString(" ", distance / 2 - 2));
                    } else {
                        final String conn = repeatString("`", distance / 4 - 4);
                        sb.append(conn);
                        sb.append(repeatString(" ", 6));
                        sb.append(conn);
                    }
                    sb.append("\\");
                    sb.append(repeatString(" ", distance / 2));
                    print(String.format(fmt, sb.toString()));
                    count2--;
                }
                println("");
            }
            leadingBlanks /= 2; // blanks/=2
        }
        println("");
    }

    public static void reverseIntArray(int[] input) {

        final int last = input.length - 1;
        if (last < 0) {
            return;
        }
        for (int i = 0; i < input.length / 2 + 1; i++) {
            if (last - i <= i) {
                return;
            }
            swap(input, i, last - i);
        }

    }

}
