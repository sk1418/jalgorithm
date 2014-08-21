/*
 * 
 */
package com.kent.datastructure;

import java.util.List;

import com.kent.util.AlgUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kent.test.BaseTest;

/**
 * The Class LRUCacheTest
 */
public class LRUCacheTest extends BaseTest {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(LRUCacheTest.class);
	LRUCache cache ;

	@Before
	public void init() {
	}

	@Test
	public void test1() {
		cache = new LRUCache(1);
		cache.set(2, 1);
		Assert.assertEquals(1, cache.get(2));
		cache.set(3, 2);
		Assert.assertEquals(-1, cache.get(2));
		Assert.assertEquals(2, cache.get(3));
	}

	@Test
	public void test2() {
		cache = new LRUCache(3);
		cache.set(1, 1);
        AlgUtil.println(cache.toString());
        cache.set(2, 2);
        AlgUtil.println(cache.toString());
		cache.set(3, 3);
        AlgUtil.println(cache.toString());
		cache.set(1, 100);
        AlgUtil.println(cache.toString());
		cache.set(4, 4);
        AlgUtil.println(cache.toString());
		Assert.assertEquals(100, cache.get(1));
		Assert.assertEquals(-1, cache.get(7));
	}

}
