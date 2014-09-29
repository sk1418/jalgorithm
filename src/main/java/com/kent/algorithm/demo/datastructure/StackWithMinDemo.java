package com.kent.algorithm.demo.datastructure;

import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoType;
import com.kent.datastructure.StackWithMin;
import com.kent.util.AlgUtil;

import static com.kent.util.AlgUtil.printStackPair;
import static com.kent.util.AlgUtil.repeatString;

/**
 * @author: Kent
 * Created on 2014-09-25.
 */
@Demo(type= DemoType.DataStructure, name="Stack With Min()")
public class StackWithMinDemo extends AbstractDemo {
    StackWithMin<Integer> stack ;
    String label, minLabel;

    @Override
    protected void prepareDemo() {
        label = "Stack";
        minLabel = "Inner-Min Stack";
        stack = new StackWithMin<>();
    }

    @Override
    protected void specificDemo() {
        print("Initial status:");
        printStackPair(stack, label, stack.getMinStack(), minLabel, 5);
        print(repeatString("=", 50));
        print("After pushed value:  0");
        stack.push(0);
        printStackPair(stack, label, stack.getMinStack(), minLabel + " min()=" + stack.min(), 5);
        print(repeatString("=", 50));
        print("After pushed value:  -1");
        stack.push(-1);
        printStackPair(stack, label, stack.getMinStack(), minLabel + " min()=" + stack.min(), 5);
        print(repeatString("=", 50));
        print("After pushed value:  1");
        stack.push(1);
        printStackPair(stack, label, stack.getMinStack(), minLabel + " min()=" + stack.min(), 5);
        print(repeatString("=", 50));
        print("After pushed value:  -1");
        stack.push(-1);
        printStackPair(stack, label, stack.getMinStack(), minLabel + " min()=" + stack.min(), 5);
        print(repeatString("=", 50));
        print("After pushed value:  0");
        stack.push(0);
        printStackPair(stack, label, stack.getMinStack(), minLabel + " min()=" + stack.min(), 5);
        print(repeatString("=", 50));
        print("Pop!");
        stack.pop();
        printStackPair(stack, label, stack.getMinStack(), minLabel + " min()=" + stack.min(), 5);
        print(repeatString("=", 50));
        print("Pop!");
        stack.pop();
        printStackPair(stack, label, stack.getMinStack(), minLabel + " min()="+stack.min(), 5);
        print(repeatString("=", 50));
        print("Pop!");
        stack.pop();
        printStackPair(stack, label, stack.getMinStack(), minLabel + " min()="+stack.min(), 5);

    }

    @Override
    protected String demoDescription() {
        return null;
    }
}
