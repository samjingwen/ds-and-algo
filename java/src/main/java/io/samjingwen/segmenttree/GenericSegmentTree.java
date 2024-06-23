package io.samjingwen.segmenttree;

public class GenericSegmentTree {

    int[] nodes;
    int capacity;

    public GenericSegmentTree(int capacity) {
        this.capacity = capacity;
        this.nodes = new int[capacity * 4];
    }

    public void build(int[] nums, int node, int left, int right) {
        if (left == right) {
            nodes[node] = nums[left];
        } else {
            int mid = left + (right - left) / 2;
            build(nums, node * 2 + 1, left, mid);
            build(nums, node * 2 + 2, mid + 1, right);
            nodes[node] = nodes[node * 2 + 1] + nodes[node * 2 + 2];
        }
    }

    public void update(int idx, int val) {
        update(0, 0, this.capacity - 1, idx, val);
    }

    private void update(int node, int left, int right, int idx, int val) {
        if (left > idx || right < idx) {
            return;
        }

        if (left == right) {
            nodes[node] = val;
            return;
        }

        int mid = left + (right - left) / 2;
        update(2 * node + 1, left, mid, idx, val);
        update(2 * node + 2, mid + 1, right, idx, val);
        nodes[node] = nodes[2 * node + 1] + nodes[2 * node + 2];
    }

    private int query(int idx, int left, int right, int start, int end) {
        if (start > end) {
            return 0;
        }

        if (start == left && end == right) {
            return nodes[idx];
        }
        int mid = left + (right - left) / 2;
        return query(idx * 2, left, mid, start, Math.min(end, mid))
                + query(idx * 2 + 1, mid + 1, right, Math.max(start, mid + 1), end);
    }

}
