import java.util.*;

class Solution {

    class SegmentTree {
        int[] tree;
        int n;

        SegmentTree(int[] values) {
            n = values.length;
            if (n == 0) return;
            tree = new int[4 * n];
            build(1, 0, n - 1, values);
        }

        void build(int node, int left, int right, int[] values) {
            if (left == right) {
                tree[node] = values[left];
                return;
            }

            int mid = (left + right) / 2;
            build(node * 2, left, mid, values);
            build(node * 2 + 1, mid + 1, right, values);
            tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
        }

        int query(int l, int r) {
            if (n == 0 || l > r) return 0;
            return query(1, 0, n - 1, l, r);
        }

        int query(int node, int left, int right, int l, int r) {
            if (l <= left && right <= r) return tree[node];

            int mid = (left + right) / 2;
            int ans = 0;

            if (l <= mid)
                ans = Math.max(ans, query(node * 2, left, mid, l, r));

            if (r > mid)
                ans = Math.max(ans, query(node * 2 + 1, mid + 1, right, l, r));

            return ans;
        }
    }

    // first index >= target
    private int lowerBound(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) >= target)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    // first index > target
    private int upperBound(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) > target)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {

        int n = s.length();
        int originalOnes = 0;

        for (char c : s.toCharArray())
            if (c == '1')
                originalOnes++;

        List<Integer> zeroLengths = new ArrayList<>();
        List<Integer> zeroStarts = new ArrayList<>();
        List<Integer> zeroEnds = new ArrayList<>();

        int i = 0;

        while (i < n) {
            int start = i;
            while (i < n && s.charAt(i) == s.charAt(start))
                i++;

            if (s.charAt(start) == '0') {
                zeroLengths.add(i - start);
                zeroStarts.add(start);
                zeroEnds.add(i - 1);
            }
        }

        int zeroCount = zeroLengths.size();

        List<Integer> ans = new ArrayList<>();

        if (zeroCount < 2) {
            for (int k = 0; k < queries.length; k++)
                ans.add(originalOnes);
            return ans;
        }

        int[] gains = new int[zeroCount - 1];

        for (i = 0; i < zeroCount - 1; i++)
            gains[i] = zeroLengths.get(i) + zeroLengths.get(i + 1);

        SegmentTree st = new SegmentTree(gains);

        for (int[] q : queries) {

            int left = q[0];
            int right = q[1];

            int firstBlock = lowerBound(zeroEnds, left);
            int lastBlock = upperBound(zeroStarts, right) - 1;

            if (firstBlock >= zeroCount || lastBlock < 0 || firstBlock >= lastBlock) {
                ans.add(originalOnes);
                continue;
            }

            int firstLength = zeroEnds.get(firstBlock)
                    - Math.max(zeroStarts.get(firstBlock), left) + 1;

            int lastLength = Math.min(zeroEnds.get(lastBlock), right)
                    - zeroStarts.get(lastBlock) + 1;

            if (firstBlock + 1 == lastBlock) {
                ans.add(originalOnes + firstLength + lastLength);
                continue;
            }

            int leftBoundaryGain =
                    firstLength + zeroLengths.get(firstBlock + 1);

            int rightBoundaryGain =
                    zeroLengths.get(lastBlock - 1) + lastLength;

            int internalGain =
                    st.query(firstBlock + 1, lastBlock - 2);

            int bestGain = Math.max(
                    Math.max(leftBoundaryGain, rightBoundaryGain),
                    internalGain);

            ans.add(originalOnes + bestGain);
        }

        return ans;
    }
}