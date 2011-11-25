package com.kent.test;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;

public class BaseTest {
    protected static final Logger log = Logger.getLogger(BaseTest.class);
    private long startTime = System.currentTimeMillis();

    protected void testInfo(String methodName) {
	log.debug("");
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
	log.info("TIME ESCAPED: " + (System.currentTimeMillis() - this.startTime) + " ms.");
	log.debug("\n\n");
    }
}
