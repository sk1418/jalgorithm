package com.kent.datastructure;

import java.util.Stack;

/**
 * Build a stack with a {@code min()} function, which returns the minimal value in current stack in O(1).
 *
 * Solution:
 *<pre>
 *     - build a inner stack (minStack), when the stack push/pop, maintain the minStack
 *     - min() returns minStack.peek()
 *</pre>
 *
 * @author: Kent
 * Created on 2014-09-21.
 */

public class StackWithMin<E extends Comparable<E>> extends Stack<E> {
    private Stack<E> minStack;

    public StackWithMin() {
        minStack = new Stack<E>();
    }

    public E push(E value) {

        if (minStack.empty()) {
            minStack.push(value);
        } else  if (value.compareTo(min()) <= 0) {
                minStack.push(value);
        }
        return super.push(value);
    }

    public E pop() {
        E value = super.pop();
        if (!minStack.empty() && value.compareTo(min()) == 0) {
            minStack.pop();
        }
        return value;
    }

    public E min() {
        if (minStack.empty()) {
            throw new IndexOutOfBoundsException("Stack is empty");
        } else {
            return minStack.peek();
        }
    }

    /**
     * @deprecated
     * This method is only for demo usage. To print the minStack status. Otherwise, this method
     * should NOT be used.
     *
     * @return the inner minStack.
     */
    public Stack<E> getMinStack() {
        return minStack;
    }
}
