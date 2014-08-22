package com.kent.algorithm.ui;

/**
 * @author: Kent
 * Created on 2014-08-10.
 */
public enum DemoType {
		CompSort("Comparison Sort", 0),
		LinearSort("Sorting in linear time", 10),
		Problems("Problems", 199),
		Test("",0),
		LinkedList("Single LinkedList Problem",99);

		public final String desc;
		private int startIndex;

		DemoType(final String text, final int startIdx) {
			desc = text;
			startIndex = startIdx;
		}

		public int nextIdx(){
			++this.startIndex;
			return this.startIndex;
		}

}
