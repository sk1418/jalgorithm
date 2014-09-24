/*
 * 
 */
package com.kent.datastructure;

import com.kent.test.BaseTest;
import com.kent.util.AlgUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class StackWithMinTest
 */
public class StackWithMinTest extends BaseTest {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(StackWithMinTest.class);
    StackWithMin<Integer> stack;


	@Test
	public void testPush() {
        stack = new StackWithMin<>();
        stack.push(0);
        stack.push(-1);
        stack.push(1);
        stack.push(-1);
        stack.push(0);
        stack.push(8);
        stack.push(0);
        stack.push(7);
        Assert.assertEquals(new Integer(-1),stack.min());
    }

	@Test(expected = IndexOutOfBoundsException.class)
	public void testPop() {
        testPush();
        Assert.assertEquals(7, (int)stack.pop());
        Assert.assertEquals(-1, (int)stack.min());

        Assert.assertEquals(0, (int)stack.pop());
        Assert.assertEquals(-1, (int)stack.min());

        Assert.assertEquals(8, (int)stack.pop());
        Assert.assertEquals(-1, (int)stack.min());

        Assert.assertEquals(0, (int)stack.pop());
        Assert.assertEquals(-1, (int)stack.min());

        Assert.assertEquals(-1, (int)stack.pop());
        Assert.assertEquals(-1, (int)stack.min());

        Assert.assertEquals(1, (int)stack.pop());
        Assert.assertEquals(-1, (int)stack.min());

        Assert.assertEquals(-1, (int)stack.pop());
        Assert.assertEquals(0, (int)stack.min());

        Assert.assertEquals(0, (int)stack.pop());
        stack.min(); //exception
	}

}
