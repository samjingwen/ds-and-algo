package io.samjingwen.segmenttree;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class GenericSegmentTreeTest {

    @Test
    void testBuild() {
        int[] nums = new int[]{2, 3, -1, 5, -2, 4, 8, 10};
        GenericSegmentTree segmentTree = new GenericSegmentTree(nums.length);
        segmentTree.build(nums, 0, 0, nums.length - 1);
        System.out.println(Arrays.toString(segmentTree.nodes));
        segmentTree.update(3, 4);
        System.out.println(Arrays.toString(segmentTree.nodes));
    }


}