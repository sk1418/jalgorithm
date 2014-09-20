package com.kent.datastructure;

import java.util.Stack;

/**
 * @author: Kent
 * Created on 2014-09-21.
 */

public class StackWithMin<E extends Comparable<E>> extends Stack<E> {
    Stack<E> minStack;

    public StackWithMin() {
        minStack = new Stack<E>();
    }

    public E push(E value) {
        if (value.compareTo(min())<0) {
            minStack.push(value);
        }
        return super.push(value);
    }

    public E pop() {
        E value = super.pop();
        if (value .compareTo( min())==0) {
            minStack.pop();
        }
        return value;
    }

    public E min() {
        if (minStack.empty()) {
            //TODO throw exception
            return  null;
        } else {
            return minStack.peek();
        }
    }
}
