package com.kent.stackoverflow;

import java.io.IOException;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kent.algorithm.problem.RemoveDupsFromSortedListTest;
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
	public void testIt2() {


		String s = "high*school";

String newString = "";
String[] arr = s.split("[*]");
if (arr.length==2){
	newString = new StringBuilder(arr[1]).reverse().toString()+arr[1];
}
		LOG.debug(newString);

	}

}

