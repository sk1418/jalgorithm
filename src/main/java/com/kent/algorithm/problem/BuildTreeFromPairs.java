package com.kent.algorithm.problem;

import com.kent.algorithm.Problem;
import com.kent.datastructure.MyTreeNode;

import java.util.*;

/**
 * <p>
 *     Given a List of String pairs and a rootString value, build a tree.
 *     </p>
 * <p>
 *     The first element is the child of the 2nd element, that is, the 2nd element is the parent of the 1st one.
 *     The given {@code rootString} would be the root node of built tree.
 * </p>
 *
 * <p>
 *     solution:
 * </p>
 * <pre>
 *     - design a TreeNode datastructure: {@link com.kent.datastructure.MyTreeNode}
 *     - convert the given pair list into hashtable/hashmap. (in fact Multimap). The key is the parent string, the value
 *     is a list, storing the children of the parent string.
 *     - from the given rootString, get and add all children of root from the hashmap, then recursively add all tree nodes
 *     from the hashmap.
 * </pre>
 *
 * @author: Kent
 * Created on 2014-09-18.
 */
public class BuildTreeFromPairs extends Problem<Map<String, Object>, MyTreeNode<String>> {
    @Override
    public String getBigO() {
        return "Time O(n)";
    }

    @Override
    public MyTreeNode<String> solve(Map<String, Object> data) {
        String rootValue = (String) data.get("root");
        List<List<String>> pairs = (List<List<String>>) data.get("pairs"); //[ ["foo","bar"],{"blah","foo"],[x,y],..]
        //convert the List -> hashmap, in fact a multimap, key is the parentValue
        HashMap<String, List<String>> vMap = new HashMap<>();
        for (List<String> pair : pairs) {
            String parent = pair.get(1);
            String child = pair.get(0);
            if (vMap.containsKey(parent)) {
                vMap.get(parent).add(child);
            } else {
                List<String> list = new ArrayList();
                list.add(child);
                vMap.put(parent, list);
            }
        }

        //build the tree
        MyTreeNode<String> rootNode = new MyTreeNode<String>(null,null, rootValue);
        buildTree(vMap, rootNode);
        return rootNode;
    }


    private void buildTree(HashMap<String, List<String>> map, MyTreeNode<String> parent) {
        String k = parent.getValue();
        if (!map.containsKey(k)) {
            return;
        }
        List<String> childValues = map.get(k);
        MyTreeNode<String> childNode ;
        for (String childValue : childValues) {
            childNode = new MyTreeNode<String>(parent, null, childValue);
            parent.addChild(childNode);
        }
        for (MyTreeNode<String> nextParent : parent.getChildren()) {
            buildTree(map, nextParent);
        }
    }

}
