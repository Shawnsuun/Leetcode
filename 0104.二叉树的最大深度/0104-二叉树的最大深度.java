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
    private int maxdp = 0;

    public int maxDepth(TreeNode root) {
        dfs(root, 1);
        return maxdp;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            maxdp = Math.max(depth, maxdp);
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}