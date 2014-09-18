package com.kent.algorithm.problem;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.kent.datastructure.MyTreeNode;
import com.kent.test.BaseTest;
import com.kent.util.AlgUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author: Kent
 * Created on 2014-09-18.
 */
public class BuildTreeFromPairsTest extends BaseTest {

    BuildTreeFromPairs problem = new BuildTreeFromPairs();
    Map<String, Object> input = Maps.newHashMap();

    @Before
    public void init() {
        String root  = "root"; //root node
        List<String> f = ImmutableList.of("a", "b");
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

    @Test
    public void testSolution() {
        MyTreeNode<String> tree = problem.solve(input);
        AlgUtil.printTreeNode(tree);

    }
}
