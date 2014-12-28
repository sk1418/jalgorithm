package com.kent.stackoverflow;

import com.google.common.primitives.Bytes;
import com.google.common.primitives.Primitives;
import com.kent.algorithm.ui.Demo;
import com.kent.datastructure.ListNode;
import com.kent.test.BaseTest;
import org.apache.commons.logging.Log;
import org.bouncycastle.crypto.engines.CAST5Engine;
import org.bouncycastle.crypto.modes.CFBBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;
import org.junit.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * only for quick test
 *
 * @author: Kent
 * Created on 2014-05-14.
 */


public class Scratch extends BaseTest {

    @Test
    public void testCipher() throws UnsupportedEncodingException {
        String plain = "I am a plain String, yohoo!";
        int blockSize = 8;
        byte[] oBytes = plain.getBytes();
        byte[] enBytes =  new byte[oBytes.length];
        byte[] deBytes =  new byte[oBytes.length];
        log.debug("plain:"+plain);
        String key = "kent.yuan";


        //encryption
        boolean doEn = true;
        CAST5Engine cast5 = new CAST5Engine();
        Random r = new Random(new Date().getTime());
        byte[] iv = new byte[8];
        r.nextBytes(iv);
        ParametersWithIV ivPara = new ParametersWithIV(new KeyParameter(Strings.toByteArray(key)), iv);
        CFBBlockCipher cfbCipher = new CFBBlockCipher(cast5, blockSize);
        cfbCipher.init(doEn, ivPara);
        for(int i=0;i<oBytes.length;i++)
            cfbCipher.processBlock(oBytes, i, enBytes, i);
        enBytes = Bytes.concat(iv, enBytes);
        String enStr = Hex.toHexString(enBytes);
        log.debug("encrtyped:"+ enStr);

        //decryption from String
        doEn = false;
        enBytes = Hex.decode(enStr);
        iv = Arrays.copyOfRange(enBytes, 0, 8);
        byte[] msgArray = Arrays.copyOfRange(enBytes, 8, enBytes.length);
        cfbCipher = new CFBBlockCipher(cast5, 8);
        cfbCipher.init(doEn, new ParametersWithIV(new KeyParameter(key.getBytes()),iv ));
        for(int i=0;i<msgArray.length;i++)
            cfbCipher.processBlock(msgArray, i, deBytes, i);
        log.debug("decrtyped:" + Strings.fromByteArray(deBytes));




    }

    @Test
//    http://stackoverflow.com/questions/26532111/java-nested-for-loops-to-get-numbers-triangle
    public void printTriangle() {
        int rows = 8;
        for (int r = 0; r <= rows; r++) {
            System.out.print(new String(new char[rows - r]).replace("\0", "  "));
            for (int i = 0; i <= r; i++) {
                System.out.printf("%s%s", 1 << i, r == 0 ? "\n" : " ");
            }
            if (r > 0) {
                for (int i = r - 1; i >= 0; i--) {
                    System.out.printf("%s%s", 1 << i, i == 0 ? "\n" : " ");
                }
            }
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
        TreeMap<String, List<String>> treeMap1 = null;
        TreeMap<String, List<String>> treeMap2 = null;
        TreeMap<String, List<String>> treeMap3 = new TreeMap<>(treeMap1);

        for (String k : treeMap3.keySet()) {
            if (treeMap2.containsKey(k)) {
                treeMap3.get(k).addAll(treeMap2.get(k));
            }
        }
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

    @Test
    //http://stackoverflow.com/questions/27336026/java-recursion-example/
    public void testAddingComma() {
        System.out.println(commas(10234500l));
    }
    public static String commas(long l) {
        if (l < 1000) {
            return String.valueOf(l);
        } else {
            long pt1Number = l / 1000;
            long pt2Number = l % 1000;
            return commas(pt1Number) + "," + (pt2Number == 0l ? "000" : String.valueOf(pt2Number));

        }

    }

}


