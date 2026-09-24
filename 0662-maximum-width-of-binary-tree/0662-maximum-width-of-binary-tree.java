/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    class Pair {
        TreeNode node;
        int index;

        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        if (root == null) return 0;

        Deque<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        int maxWidth = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            int start = q.peekFirst().index;
            int end = q.peekLast().index;

            maxWidth = Math.max(maxWidth, end - start + 1);

            for (int i = 0; i < size; i++) {

                Pair curr = q.poll();

                if (curr.node.left != null) {
                    q.offer(new Pair(curr.node.left, curr.index * 2 + 1));
                }

                if (curr.node.right != null) {
                    q.offer(new Pair(curr.node.right, curr.index * 2 + 2));
                }
            }
        }

        return maxWidth;
    }
}