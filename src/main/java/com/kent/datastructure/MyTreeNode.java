package com.kent.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Kent
 * Created on 2014-09-18.
 */


public class MyTreeNode<T> {
    private T value;
    private MyTreeNode<T> parent;
    private List<MyTreeNode<T>> children = new ArrayList<>();

    public MyTreeNode(MyTreeNode<T> parent, List<MyTreeNode<T>> children, T value) {
        this.parent = parent;
        this.children = children;
        this.value = value;
    }

    public void addChild(MyTreeNode<T> newChild) {
        if(children == null)
            children = new ArrayList<>();
        children.add(newChild);
        newChild.setParent(this);
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public MyTreeNode<T> getParent() {
        return parent;
    }

    public void setParent(MyTreeNode<T> parent) {
        this.parent = parent;
    }

    public List<MyTreeNode<T>> getChildren() {
        if (children==null)
            children = new ArrayList<>();
        return children;
    }

}

