package com.kent.stackoverflow;

import com.kent.algorithm.ui.Demo;
import com.kent.datastructure.ListNode;
import com.kent.test.BaseTest;
import org.junit.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    //http://stackoverflow.com/questions/26336486/pyramid-numbers-in-alternative-reverse-order/26337599#26337599
    public void printPyramid() {
        int x = 105;
        int rows = Double.valueOf(Math.sqrt(2 * x)).intValue();
        int n = 1;
        for (int r = 1; r <= rows; r++) {
            System.out.print(new String(new char[rows - r]).replace("\0", " "));
            if ((r & 1) != 0)
                for (int i = n; i < n + r && n + r <= x; i++)
                    System.out.printf("%s%s", i, i == n + r - 1 || i == x ? "\n" : " ");
            else
                for (int i = n + r - 1 > x ? x : n + r - 1; i >= n; i--)
                    System.out.printf("%s%s", i, i == n ? "\n" : " ");
            n = n + r;
        }
    }

    @Test
    public void testIt2() throws Exception {
        Reflections reflections = new Reflections("com.kent.algorithm.demo");

        Set<Class<?>> subTypes = reflections.getTypesAnnotatedWith(Demo.class);

        for (Class c : subTypes) {
            LOG.debug(c.getCanonicalName());
        }

        LOG.debug("ff");
    }


    @Test
    public void testRestInLoop() {
        int min = 0, max = 99;
        int[] arr = {0, 1, 3, 50, 75};
        printRestRangeLoop(arr, min, max);
    }

    private void printRestRangeLoop(int[] arr, int min, int max) {
        System.out.print("[");
        int current = min;
        boolean hasElement = false;
        for (int idx = 0; idx < arr.length; idx++) {
            if (arr[idx] > current) {
                System.out.printf("%s%s%s", hasElement ? "," : "", current,
                        arr[idx] == current + 1 ? "" : "-" + (arr[idx] - 1));
                hasElement = true;
            }
            current = arr[idx] + 1;
        }
        if (current <= max)
            System.out.printf("%s%s", hasElement ? "," : "", current == max ? max : current + "-" + max);
        System.out.println("]");
    }

    @Test
    public void test2dArray() {
        double[][] arr = {
                {0.5, 0.62, 0.35, 0.6, 0.5},
                {1, 2, 3, 4, 5},
                {0.65, 0.85, 0.2, 0.2, 0.8},
                {10, 20, 30, 40, 50},
                {0.65, 0.85, 0.2, 0.2, 0.8},
                {100, 200, 300, 400, 500},
        };

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 1) {
                for (int j = arr[i].length - 1; j >= 0; j--)
                    System.out.printf("%-10s", arr[i][j]);
            } else {
                for (int j = 0; j < arr[i].length; j++)
                    System.out.printf("%-10s", arr[i][j]);
            }
            System.out.println("");
        }
    }

    @Test
    public void testMergeList() {
        final ListNode list1 = new ListNode(1);
        final ListNode n2 = new ListNode(2);
        final ListNode n3 = new ListNode(3);
        final ListNode n4 = new ListNode(4);
        final ListNode n5 = new ListNode(5);

        list1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        final ListNode list2 = new ListNode(6);
        final ListNode n7 = new ListNode(7);
        final ListNode n8 = new ListNode(8);
        final ListNode n9 = new ListNode(9);
        final ListNode n10 = new ListNode(10);

        list2.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;

        ListNode result = mergeLists(list1, list2);
        log.debug(result.toString());


    }

    private ListNode mergeLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(-1);
        ListNode head = result;
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode[] pool = {list1, list2};
        ListNode working = null;
        int i = 0;
        while (true) {
            int idx = i++ % 2;
            working = pool[idx];
            head.next = working;
            head = head.next;
            if (working.next == null) break;
            pool[idx] = working.next;
        }
        head.next = pool[i % 2];
        return result.next;
    }

    @Test
    public void testIt02() {
        //http://stackoverflow.com/questions/11284581/find-shortest-part-of-sentence-containing-given-words
        final String s = "My name is not eugene. my pet name is not eugene.";
        final String tmp = s.toLowerCase().replaceAll("[^a-zA-Z]", " ");// here we need the placeholder (blank)
        final String w1 = "my "; // leave a blank at the end to avoid those words e.g. "myself", "myth"..
        final String w2 = "eugene ";// same as above
        final List<Integer> l1 = getList(tmp, w1); // indexes list
        final List<Integer> l2 = getList(tmp, w2);
        int min = Integer.MAX_VALUE;
        final int[] idx = new int[]{0, 0};

        // loop to find out the result
        for (final int i : l1) {
            for (final int j : l2) {
                if (Math.abs(j - i) < min) {
                    final int x = j - i;
                    min = Math.abs(j - i);
                    idx[0] = j - i > 0 ? i : j;
                    idx[1] = j - i > 0 ? j + w2.length() + 2 : i + w1.length() + 2;
                }
            }

        }

        System.out.println("indexes: " + Arrays.toString(idx));
        System.out.println("result: " + s.substring(idx[0], idx[1]));
    }

    private List<Integer> getList(final String input, final String search) {
        String t = new String(input);
        final List<Integer> list = new ArrayList<Integer>();
        int tmp = 0;
        while (t.length() > 0) {
            final int x = t.indexOf(search);

            if (x < 0 || x > t.length()) {
                break;
            }
            tmp += x;
            list.add(tmp);
            t = t.substring(search.length() + x);

        }
        return list;

    }
}


