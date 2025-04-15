class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] posInNums2 = new int[n];
        for (int i = 0; i < n; i++) {
            posInNums2[nums2[i]] = i;
        }

        FenwickTree bitLeft = new FenwickTree(n);
        long[] leftCount = new long[n];

        // Count left numbers
        for (int i = 0; i < n; i++) {
            int idx = posInNums2[nums1[i]];
            leftCount[i] = bitLeft.query(idx - 1);
            bitLeft.update(idx, 1);
        }

        FenwickTree bitRight = new FenwickTree(n);
        long result = 0;

        // Count good triplets
        for (int i = n - 1; i >= 0; i--) {
            int idx = posInNums2[nums1[i]];
            long rightCount = bitRight.query(n - 1) - bitRight.query(idx);
            result += leftCount[i] * rightCount;
            bitRight.update(idx, 1);
        }

        return result;
    }
}

// Fenwick Tree implementation
class FenwickTree {
    long[] tree;
    int size;

    public FenwickTree(int n) {
        size = n + 2;
        tree = new long[size];
    }

    public void update(int index, long value) {
        index += 1;
        while (index < size) {
            tree[index] += value;
            index += index & -index;
        }
    }

    public long query(int index) {
        index += 1;
        long sum = 0;
        while (index > 0) {
            sum += tree[index];
            index -= index & -index;
        }
        return sum;
    }
}
