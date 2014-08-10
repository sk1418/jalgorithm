package com.kent.stackoverflow;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kent.algorithm.ui.Demo;
import com.kent.test.BaseTest;

/**
 * only for quick test
 *
 * @author: Kent
 * Created on 2014-05-14.
 */

public class Scratch extends BaseTest {

	private static final Logger LOG = LoggerFactory.getLogger(Scratch.class);

	@Test
	public void testIt() {


		String s = "en_actions_.add(new ClusterEntry<String>(\"photography\",-1, 2, 620554,\"photography \",null));";
		Pattern p = Pattern.compile("(?<=>\\()[^)]*");
		Matcher m = p.matcher(s);
		if (m.find()) {
			System.out.println(m.group());
		}


	}
	@Test
	public void testIt2() throws  Exception{
		 Reflections reflections = new Reflections("com.kent.algorithm.demo");

		Set<Class<?>> subTypes = reflections.getTypesAnnotatedWith(Demo.class);

		for (Class c : subTypes) {
			LOG.debug(c.getCanonicalName());
		}






		LOG.debug("ff");

	}

}

