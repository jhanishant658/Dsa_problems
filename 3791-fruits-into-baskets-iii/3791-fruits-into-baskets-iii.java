class SegmentTree {
    private int n;           // size of input array
    private int[] tree;      // segment tree array

    public SegmentTree(int[] nums) {
        this.n = nums.length;
        this.tree = new int[n * 4]; // safe size for segment tree
        build(nums, 0, 0, n - 1);
    }

    // Update baskets[i] = val
    public void update(int i, int val) {
        update(0, 0, n - 1, i, val);
    }

    // Returns first index where baskets[index] >= target, or -1 if not found
    public int queryFirst(int target) {
        return queryFirst(0, 0, n - 1, target);
    }

    // Build segment tree
    private void build(int[] nums, int treeIndex, int lo, int hi) {
        if (lo == hi) {
            tree[treeIndex] = nums[lo];
            return;
        }
        int mid = (lo + hi) / 2;
        build(nums, 2 * treeIndex + 1, lo, mid);
        build(nums, 2 * treeIndex + 2, mid + 1, hi);
        tree[treeIndex] = Math.max(tree[2 * treeIndex + 1], tree[2 * treeIndex + 2]);
    }

    private void update(int treeIndex, int lo, int hi, int i, int val) {
        if (lo == hi) {
            tree[treeIndex] = val;
            return;
        }
        int mid = (lo + hi) / 2;
        if (i <= mid)
            update(2 * treeIndex + 1, lo, mid, i, val);
        else
            update(2 * treeIndex + 2, mid + 1, hi, i, val);
        tree[treeIndex] = Math.max(tree[2 * treeIndex + 1], tree[2 * treeIndex + 2]);
    }

    private int queryFirst(int treeIndex, int lo, int hi, int target) {
        if (tree[treeIndex] < target)
            return -1; // No basket in this range can fit the fruit

        if (lo == hi) {
            // Found a valid basket, mark as used
            update(lo, -1);
            return lo;
        }

        int mid = (lo + hi) / 2;
        if (tree[2 * treeIndex + 1] >= target)
            return queryFirst(2 * treeIndex + 1, lo, mid, target);
        else
            return queryFirst(2 * treeIndex + 2, mid + 1, hi, target);
    }
}

class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        SegmentTree tree = new SegmentTree(baskets);
        int ans = 0;

        for (int fruit : fruits) {
            if (tree.queryFirst(fruit) == -1) {
                ans++;
            }
        }

        return ans;
    }
}
