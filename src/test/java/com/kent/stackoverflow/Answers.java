package com.kent.stackoverflow;

import java.util.Arrays;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.junit.Test;

import com.kent.test.BaseTest;

/**
 * Some interesting Question on SO with my answers.
 * @author: Kent
 * Created on 2014-05-14.
 */
public class Answers extends BaseTest{


	/**
	 * soLink:http://stackoverflow.com/questions/13674536/splitting-a-string-array-in-java/13674785#13674785
	 *
	 * split an array into two arrays, result would be in 2-D array. the spliter element should be removed.
	 *
	 * ["Good","Bad","Sad"] if i split it at 1 it would give me a string matrix that looked like this [["Good"],["Sad"]]
	 *
	 */
	@Test
	public void splitStringArray() {
		printLink("splitStringArray", "http://stackoverflow.com/questions/13674536/splitting-a-string-array-in-java/13674785#13674785");
		final String[] input = new String[] { "one", "two", "three", "four", "five", "six", "seven", "eight" };
		final int len = input.length;
		final int pos = 3;
		final String[][] result = new String[2][Math.max(pos, len - pos - 1)];
		result[0] = Arrays.copyOf(input, 3);
		result[1] = Arrays.copyOfRange(input, pos + 1, len);
		log.info(result.toString());

	}

	/**
	 * soLink: http://stackoverflow.com/questions/13211015/string-containing-time-1h4m10s-converted-to-seconds
	 *
	 * convert "5W3D10H5M10S" to seconds, the function would return "3319510"
	 *
	 * @throws Exception
	 */
	@Test
	public void convertTimeStrToSeconds() throws Exception {
		printLink("convertTimeStrToSeconds", "http://stackoverflow.com/questions/13211015/string-containing-time-1h4m10s-converted-to-seconds");
		final String in = "5W3D10H5M10S";
		final String after = in.replaceAll("W", "*7D").replaceAll("D", "*24H").replaceAll("H", "*60M").replaceAll("M", "*60+").replaceAll("S", "");
		final ScriptEngineManager manager = new ScriptEngineManager();
		final ScriptEngine engine = manager.getEngineByName("js");
		final Object result = engine.eval(after);
		log.info("Result:" + String.valueOf(result));
	}

	/**
	 * soLink: http://stackoverflow.com/questions/13918167/java-exercise-display-table-with-2d-array
	 *
	 * initialize an int[][] and print in table format.
	 *
	 * e.g. <br/>
	 * +-+-+-+-+-+ <br/>
	 * |1|2|3|4|5| <br/>
	 * +-+-+-+-+-+ <br/>
	 * |2|3|4|5|1| <br/>
	 * +-+-+-+-+-+ <br/>
	 * |3|4|5|1|2| <br/>
	 * +-+-+-+-+-+ <br/>
	 * |4|5|1|2|3|<br/>
	 * +-+-+-+-+-+ <br/>
	 * |5|1|2|3|4| <br/>
	 * +-+-+-+-+-+
	 */
	@Test
	public void print2DIntArrayInTbl() {
		printLink("print2DIntArrayInTbl", "http://stackoverflow.com/questions/13918167/java-exercise-display-table-with-2d-array");
		final int num = 9;
		final int[][] data = new int[num][num];
		for (int r = 0; r < data.length; r++) {
			for (int c = 0; c < data[r].length; c++) {
				final int t = r + c + 1;
				data[r][c] = t <= num ? t : t - num;
			}
		}
		// now we have all int data in data 2D-array

		// here is the +-+- line
		final StringBuilder sb = new StringBuilder("+");
		for (final int[] element : data) {
			sb.append("-+");
		}

		// now print the table
		for (final int[] element : data) {
			System.out.println(sb.toString());
			for (int c = 0; c < data.length; c++) {
				System.out.print("|" + element[c]);
			}
			System.out.println("|");
		}
		System.out.println(sb.toString());
	}

	private void printLink(final String desc, final String link) {
		System.out.println("  ");
		System.out.println("desc  : " + desc);
		System.out.println("link  : " + link);
		System.out.println("  ");
	}
}
