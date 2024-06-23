package io.samjingwen.segmenttree;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MaxRangeSegmentTreeTest {

    @Test
    void testTree() {
        int[] nums = new int[]{2, 3, -1, 5, -2, 4, 8, 10};
        MaxRangeSegmentTree segmentTree = new MaxRangeSegmentTree(nums.length);

        segmentTree.build(nums, 0, 0, nums.length - 1);

        System.out.println(Arrays.toString(segmentTree.nodes));
        System.out.println(segmentTree.query(2, 6));


        segmentTree.update(7, -10);
        System.out.println(Arrays.toString(segmentTree.nodes));
    }


}