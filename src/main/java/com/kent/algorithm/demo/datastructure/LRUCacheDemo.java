package com.kent.algorithm.demo.datastructure;

import com.google.common.base.Joiner;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoType;
import com.kent.datastructure.LRUCache;
import com.kent.util.AlgUtil;

/**
 * @author: Kai Yuan
 * Created on 2014-08-21.
 */
@Demo(type= DemoType.DataStructure, name = "Least Recently Used (LRU) cache")
public class LRUCacheDemo extends AbstractDemo {
   LRUCache cache;


    @Override
    protected void warmingUp() {

    }

    @Override
    protected void prepareDemo() {
        cache = new LRUCache(4);
        cache.set(3, 3);
        cache.set(2, 2);
        cache.set(1, 1);
    }

    @Override
    protected void specificDemo() {
        print("Init LRUCache Status:");
        printLine("=", 50);
        print(cache.toString());
        printLine("=", 50);
        print("# cache.set(4,5) :");
        cache.set(4, 5);
        print(cache.toString());
        printLine("=", 50);
        print("# cache.get(3) :");
        print(String.format("return value:%d", cache.get(3)));
        print(cache.toString());
        printLine("=", 50);
        print("# cache.get(8) :");
        print(String.format("return value:%d", cache.get(8)));
        print(cache.toString());
        printLine("=", 50);
        print("# cache.set(2,200) :");
        cache.set(2,200);
        print(cache.toString());
        printLine("=", 50);
        print("# cache.set(7,77) :");
        cache.set(7,77);
        print(cache.toString());
    }

    @Override
    protected String demoDescription() {
         return Joiner.on("\n").join(new String[]{
                " Design and implement a data structure for Least Recently Used (LRU) cache.",
                " It should support the following operations: get and set.",
                " ",
                " get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.",
                " set(key, value) - Set or insert the value if the key is not already present.",
                "				   When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.",
                " ",
                "Solution",
                " ",
                "    - Idea is using a double-linked list to store the k-v pairs",
                "    - when get/set, just re-arrange the node in the linkedlist, thus O(1)",
                "    - using a map(hashmap) to store the reference of k -> node, so that get() has O(1)",
                "    - if with built-in LinkedHashMap, the problem could be much easiser implemented. (with protected boolean removeEldestEntry(Map.Entry eldest)",
                " ",
        });
    }
}
