package io.samjingwen.segmenttree;

public class MaxRangeSegmentTree {

    public int[] nodes;
    public int maxSize;

    public MaxRangeSegmentTree(int maxSize) {
        this.maxSize = maxSize;
        this.nodes = new int[maxSize * 4];
    }

    public void build(int[] nums, int i, int left, int right) {
        if (left == right) {
            nodes[i] = nums[left];
        } else {
            int mid = left + (right - left) / 2;
            build(nums, i * 2 + 1, left, mid);
            build(nums, i * 2 + 2, mid + 1, right);
            nodes[i] = Math.max(nodes[i * 2 + 1], nodes[i * 2 + 2]);
        }
    }

    public void update(int idx, int value) {
        update(0, 0, maxSize - 1, idx, value);
    }

    public int query(int start, int end) {
        return query(0, 0, maxSize - 1, start, end);
    }

    private void update(int node, int left, int right, int idx, int value) {
        if (left > idx || right < idx) {
            return;
        }

        if (left == right) {
            nodes[node] = value;
            return;
        }

        int mid = left + (right - left) / 2;
        update(2 * node + 1, left, mid, idx, value);
        update(2 * node + 2, mid + 1, right, idx, value);
        nodes[node] = Math.max(nodes[2 * node + 1], nodes[2 * node + 2]);
    }

    private int query(int node, int left, int right, int start, int end) {
        if (start > right || end < left) {
            return Integer.MIN_VALUE;
        }

        if (start <= left && end >= right) {
            return nodes[node];
        }

        int mid = left + (right - left) / 2;
        int leftMax = query(2 * node + 1, left, mid, start, end);
        int rightMax = query(2 * node + 2, mid + 1, right, start, end);
        return Math.max(leftMax, rightMax);
    }

}
