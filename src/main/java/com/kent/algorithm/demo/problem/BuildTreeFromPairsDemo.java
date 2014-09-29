package com.kent.algorithm.demo.problem;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.kent.algorithm.demo.AbstractDemo;
import com.kent.algorithm.problem.BuildTreeFromPairs;
import com.kent.algorithm.ui.Demo;
import com.kent.algorithm.ui.DemoType;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.kent.util.AlgUtil.printTreeNode;
import static com.kent.util.AlgUtil.repeatString;

/**
 * @author: Kent
 * Created on 2014-09-19.
 */
@Demo(type= DemoType.DataStructure,name = "Build Tree from Pair List")
public class BuildTreeFromPairsDemo extends AbstractDemo {

    BuildTreeFromPairs problem = new BuildTreeFromPairs();
    Map<String, Object> input = Maps.newHashMap();

    @Override
    protected void prepareDemo() {
        String root = "root"; //root node
        List<List<String>> pairs = Lists.newArrayList();
        pairs.addAll(Arrays.asList(
                ImmutableList.of("c1", "root"),
                ImmutableList.of("c2", "root"),
                ImmutableList.of("c3", "root"),
                ImmutableList.of("c1-1", "c1"),
                ImmutableList.of("c1-2", "c1"),
                ImmutableList.of("c1-3", "c1"),
                ImmutableList.of("c1-4", "c1"),
                ImmutableList.of("c2-1", "c2"),
                ImmutableList.of("c2-2", "c2"),
                ImmutableList.of("c2-3", "c2"),
                ImmutableList.of("c2-2-1", "c2-2"),
                ImmutableList.of("c2-2-2", "c2-2"),
                ImmutableList.of("c2-2-3", "c2-2"),
                ImmutableList.of("c2-2-2-1", "c2-2-2"),
                ImmutableList.of("c2-2-2-2", "c2-2-2"),
                ImmutableList.of("c3-1", "c3"),
                ImmutableList.of("c3-2", "c3")));
        input.put("pairs", pairs);
        input.put("root", root);
    }

    @Override
    protected void specificDemo() {
        print(String.format("Complexity: %s\n", problem.getBigO()));
        print("Root value: " + input.get("root"));
        print("Pair List : ");
        int i = 0;
        for (List<String> p : (List<List<String>>) input.get("pairs")) {
            printf("[%s, %s],%s", p.get(0), p.get(1), ++i % 4 == 0 ? "\n" : "");
        }
        print("");
        print(repeatString("=", 50));
        print("Tree Output : ");
        stopwatch.start();
        printTreeNode(problem.solve(input));

        stopwatch.stop();
        print(stopwatch.readAsString());
        print(repeatString("=", 50));
        stopwatch.reset();
    }


    @Override
    protected String demoDescription() {
        return Joiner.on("\n").join(
                " ",
                "     Given a List of String pairs and a rootString value, build a tree.",
                "     The first element is the child of the 2nd element, that is, the 2nd element is the parent of the 1st one.",
                "     The given {@code rootString} would be the root node of built tree.",
                "",
                "     solution:",
                " ",
                "     - design a TreeNode datastructure: {@link com.kent.datastructure.MyTreeNode}",
                "     - convert the given pair list into hashtable/hashmap. (in fact Multimap). The key is the parent string, the value",
                "     is a list, storing the children of the parent string.",
                "     - from the given rootString, get and add all children of root from the hashmap, then recursively add all tree nodes",
                "     from the hashmap."
        );
    }
}
