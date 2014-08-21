package com.kent.algorithm.demo.datastructure;

import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoType;
import com.kent.datastructure.LRUCache;
import com.kent.util.AlgUtil;

/**
 * @author: Kai Yuan
 * Created on 2014-08-21.
 */
@Demo(type= DemoType.LinkedList, name = "Least Recently Used (LRU) cache")
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
    protected void printDescription() {

    }
}
