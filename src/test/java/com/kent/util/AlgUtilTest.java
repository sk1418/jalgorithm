package com.kent.util;

import java.util.*;

import com.kent.datastructure.MyTreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.Assert;
import org.junit.Test;

import javax.swing.tree.TreeNode;

//import org.apache.log4j.Logger;

/**
 * The Class AlgUtilTest.
 */
public class AlgUtilTest {
	private static final Logger log = LoggerFactory.getLogger(AlgUtilTest.class);


    @Test
    public void testPrintMyTreeNode() {
        MyTreeNode<String> root = new MyTreeNode<>(null, null, "root");
        MyTreeNode<String> c1 = new MyTreeNode<>(root, null, "c1");
        MyTreeNode<String> c2= new MyTreeNode<>(root, null, "c2");
        MyTreeNode<String> c3= new MyTreeNode<>(root, null, "c3");

        root.addChild(c1);
        root.addChild(c2);
        root.addChild(c3);


        MyTreeNode<String> c11 = new MyTreeNode<>(null, null, "c1-1");
        MyTreeNode<String> c12= new MyTreeNode<>(null, null, "c1-2");
        MyTreeNode<String> c13= new MyTreeNode<>(null, null, "c1-3");

        MyTreeNode<String> c21 = new MyTreeNode<>(null, null, "c2-1");
        MyTreeNode<String> c22= new MyTreeNode<>(null, null, "c2-2");
        MyTreeNode<String> c23= new MyTreeNode<>(null, null, "c2-3");

        c1.addChild(c11);
        c1.addChild(c12);
        c1.addChild(c13);

        c2.addChild(c21);
        c2.addChild(c22);
        c2.addChild(c23);

        MyTreeNode<String> c231 = new MyTreeNode<>(null, null, "c2-3-1");
        MyTreeNode<String> c232= new MyTreeNode<>(null, null, "c2-3-2");

        c23.addChild(c231);
        c23.addChild(c232);

        MyTreeNode<String> c31= new MyTreeNode<>(null, null, "c3-1");
        MyTreeNode<String> c32= new MyTreeNode<>(null, null, "c3-2");
        c3.addChild(c31);
        c3.addChild(c32);
        AlgUtil.printTreeNode(root);
    }

	/**
	 * Gets the random int array test.
	 */
	@Test
	public void testGetRandomIntArray() {
		final int[] a = AlgUtil.getRandomIntArray(100, 10000, false);
		final int[] b = AlgUtil.getRandomIntArray(100, 20, true);

		for (final int element : a) {
			Assert.assertTrue(element >= 0 && element < 10000);
		}

		boolean hasNegative = false;
		for (final int element : b) {
			Assert.assertTrue(element < 10000);
			hasNegative = element < 0 ? true : hasNegative;
		}
		Assert.assertTrue(hasNegative);

	}

	/**
	 * Adds the int to array test.
	 */
	@Test
	public void testAddIntToArray() {
		final int[] a = new int[] { 1, 2, 3 };
		final int[] result = AlgUtil.appendIntArray(a, 4);
		Assert.assertEquals(4, result.length);
		Assert.assertEquals(4, result[result.length - 1]);

	}

	@Test
	public void testPrintHeap() {
		final int[] testArray = new int[] { 82, 2, 32, 768, 23, 106, 0, 23, 39, 34, 56, 16, 90, 17, 28, 48, 88, 99, 100, 120, 8, 27, 31 };
		final int[] testArray2 = new int[] { 82, 2 };
		AlgUtil.printBinaryTree(testArray, testArray.length, 6);
		AlgUtil.printBinaryTree(testArray2, testArray2.length, 1);
	}

	@Test
	public void testReverseIntArray() {
		final int[] a = new int[] { 1, 2, 3, 4, 5, 6 };
		final int[] b = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		final int[] resultA = new int[] { 6, 5, 4, 3, 2, 1 };
		final int[] resultB = new int[] { 7, 6, 5, 4, 3, 2, 1 };
		AlgUtil.reverseIntArray(a);
		AlgUtil.reverseIntArray(b);
		Assert.assertArrayEquals(a, resultA);
		Assert.assertArrayEquals(b, resultB);
	}

    @Test
    public void testPrintStack() {
        Stack<String> stack = new Stack<>();
        stack.push("one");
        stack.push("two");
        stack.push("three");
        stack.push("four");
        AlgUtil.printStack(stack, "test1",7);
        Stack<String> stack2 = new Stack<>();
        AlgUtil.printStack(stack2,"testempty",  7);
    }

    @Test
    public void testPrintStackPair() {
        Stack<String> stack = new Stack<>();
        stack.push("one");
        stack.push("two");
        stack.push("three");
        stack.push("four");
        Stack<String> stack2 = new Stack<>();
        stack2.push("001");
        stack2.push("002");
        stack2.push("003");

        AlgUtil.printStackPair(stack, "stack1", stack2,"PairStack",  7);
    }
}
