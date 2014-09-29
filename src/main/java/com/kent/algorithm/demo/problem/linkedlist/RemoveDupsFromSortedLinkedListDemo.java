package com.kent.algorithm.demo.problem.linkedlist;

import com.google.common.base.Joiner;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.linkedlist.RemoveDupsFromSortedLinkedList;
import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoType;
import com.kent.datastructure.ListNode;

import static com.kent.util.AlgUtil.repeatString;

@Demo(type = DemoType.LinkedList, name = "Remove Dups From Sorted List")
public class RemoveDupsFromSortedLinkedListDemo extends AbstractDemo {

    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(1);
    ListNode n3 = new ListNode(1);
    ListNode n4 = new ListNode(2);
    ListNode n5 = new ListNode(3);
    ListNode n6 = new ListNode(3);
    ListNode n7 = new ListNode(4);
    ListNode n8 = new ListNode(5);

    private RemoveDupsFromSortedLinkedList problem;

    @Override
    protected void warmingUp() { // warming up is not required
    }

    @Override
    protected void prepareDemo() {
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = null;

        problem = new RemoveDupsFromSortedLinkedList();
        problem.setPrintSteps(true);
    }

    @Override
    protected void specificDemo() {
        print(String.format("Complexity: %s\n", problem.getBigO()));
        doJob(n1);
    }

    private void doJob(final ListNode input) {

        print("Given LinkedList :" + input.toString());
        stopwatch.start();
        final ListNode newHead = problem.solve(input);
        stopwatch.stop();
        print("Result           :" + newHead.toString());
        print(stopwatch.readAsString());
        print(repeatString("=", 50));
        stopwatch.reset();
    }

    @Override
    protected String demoDescription() {
        //@formatter:off
        return Joiner.on("\n").join(
                " Given a sorted linked list, delete all duplicates such that each element appear only once.",
                " ",
                " For example,",
                " Given 1->1->2, return 1->2.",
                " Given 1->1->2->3->3, return 1->2->3.",
                " ",
                " Solution/Algorithm<",
                " ",
                " ",
                " Double pointer solution: (Please read source codes for single pointer solution.)",
                " - create two pointers (uniq and work)",
                " - iterate the following steps if work!=null:",
                "   -> if work.next.val == work.val, work goes to next, till a work.next has different value from work",
                "   -> uniq.next = work.next; uniq = uniq.next; work = work.next;"

        );
        //@formatter:on

    }

}
