package com.kent.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * From https://oj.leetcode.com/problems/lru-cache/
 * <p>
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and set.
 * </p>
 * <p/>
 * <pre>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present.
 * 					 When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * </pre>
 * <p/>
 * <pre>
 *    - Idea is using a double-linked list to store the k-v pairs
 *    - when get/set, just re-arrange the node in the linkedlist, thus O(1)
 *    - using a map(hashmap) to store the reference of k -> node, so that get() has O(1)
 *    - if with built-in LinkedHashMap, the problem could be much easiser implemented. (with protected boolean removeEldestEntry(Map.Entry<K,V> eldest)
 * </pre>
 *
 * @author: Kent
 * Created on 2014-08-21.
 */
public class LRUCache {

    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class DLinkedList {
        Node first;
        Node last;
    }

    private final int capacity;
    private DLinkedList innerList;

    //create a map to get node by key with O(1)
    Map<Integer, Node> innerMap = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        innerList = new DLinkedList();
    }

    public int get(int key) {
        if (innerMap.containsKey(key)) {
            Node node = innerMap.get(key);
            removeNode(node);
            addNewHead(node);

            return node.value;
        } else {
            return -1;
        }

    }

    public void set(int key, int value) {
        Node n = new Node(key, value);
        if (innerMap.containsKey(key)) {
            removeNode(innerMap.get(key));
        } else if (innerMap.size() == capacity) {
            removeNode(innerList.last);
        }
        addNewHead(n);
        innerMap.put(key, n);
    }

    private Node removeNode(Node node) {
        Node myPre = node.pre;
        Node myNext = node.next;
        if (myPre != null) {
            myPre.next = myNext;
        } else {
            innerList.first = myNext;
        }
        if (myNext != null) {
            myNext.pre = myPre;
        } else {
            innerList.last = myPre;
        }

        node.pre = null;
        node.next = null;
        innerMap.remove(node.key);
        return node;
    }

    private void addNewHead(Node node) {
        if (innerList.first != null) {
            innerList.first.pre = node;
            node.next = innerList.first;
        } else { // the cache is empty
            innerList.last = node;
        }
        innerList.first = node;
        innerMap.put(node.key, node);
    }

    //only for demo
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String nodeFmt = "[k:%d, v:%d]";
        sb.append(String.format("LRUCache(%d) :", capacity));
        if (innerMap.size() == 0) {
            sb.append("[null]");
        } else {
            Node n = innerList.first;
            sb.append(String.format(nodeFmt, n.key, n.value));
            n = n.next;
            while (n != null) {
                sb.append(" -> ");
                sb.append(String.format(nodeFmt, n.key, n.value));
                n = n.next;
            }
        }

        return sb.toString();
    }
}
