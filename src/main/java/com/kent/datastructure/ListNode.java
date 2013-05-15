package com.kent.datastructure;

import java.util.List;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * A simple single linkedlist structure, used by some problems
 * 
 * @author kent
 * 
 */
public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(final int x) {
		val = x;
		next = null;
	}

	/**
	 * just for unit testing
	 * 
	 * @return
	 */
	public List<Integer> toList() {
		final List<Integer> l = Lists.newArrayList();
		ListNode node = this;
		while (node != null) {
			l.add(node.val);
			node = node.next;
		}
		return l;
	}

	@Override
	public String toString() {
		return Joiner.on(", ").join(toList());
	}
}
