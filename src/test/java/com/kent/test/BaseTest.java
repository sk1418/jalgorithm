package com.kent.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.After;
import org.junit.Before;

public class BaseTest {
	protected static final Logger log = LoggerFactory.getLogger(BaseTest.class);
	private long startTime = System.currentTimeMillis();

	protected void testInfo(final String methodName) {
		log.debug("");
		log.debug("============================");
		log.debug(" Testing " + methodName);
		log.debug("============================");
	}

	@Before
	public void prepare() {
		startTime = System.currentTimeMillis();
	}

	@After
	public void endTest() {
		log.info("Elapsed: " + (System.currentTimeMillis() - startTime) + " ms.");
	}
}
