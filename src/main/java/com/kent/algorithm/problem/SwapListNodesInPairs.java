package com.kent.algorithm.problem;

import com.kent.algorithm.Problem;
import com.kent.datastructure.ListNode;
import com.kent.util.AlgUtil;

/**
 * <p>
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example
 * 
 * <pre>
 * {@code
 * [1->2->3->4] to [2->1->4->3]  
 * }</code> .
 * 
 * Your algorithm should use only <b>constant</b> space. You may not modify the values in the list, only nodes itself can be changed.
 * 
 * </p>
 * 
 * <b>Solution/Algorithm</b>
 * 
 * <pre>
 *  current processing node: curr= b
 * 
 *    ....-> a -> b -> c -> d ...
 * 
 *    ....-> a    b -> c -> d ...
 *           |         ^
 *           +---------|
 * 
 *                +---------+
 *                |         v
 *    ....-> a    b    c -> d ...
 *           |         ^
 *           +---------|
 * 
 *                +---------+
 *                |         v
 *    ....-> a    b <- c    d ...
 *           |         ^
 *           +---------|
 *    
 *    ....-> a -> c -> b -> d ...       
 * 
 *    curr = b.next (d)
 * </pre>
 * 
 * @author kent
 * 
 */
public class SwapListNodesInPairs extends Problem<ListNode, ListNode> {

	@Override
	public String getBigO() {
		return "Time: O(n); Space: O(1)";
	}

	@Override
	public ListNode solve(ListNode data) {
		ListNode nn; // next of next
		ListNode n; // next node
		ListNode pre = null; // previous node
		final ListNode head = data != null && data.next != null ? data.next : data; // get head to be returned
		while (data != null && data.next != null) {
			nn = data.next.next;
			n = data.next;
			if (pre != null) {
				pre.next = n;
			}
			data.next = nn;
			n.next = data;
			pre = data;
			data = data.next;

			// only for demo
			if (printSteps()) {
				AlgUtil.println("step status: " + head.toString());
			}

		}

		return head;
	}

}
