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
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        LinkedList<Integer> path = new LinkedList<Integer>();
        dfs(root, target, path, res);
        return res;
    }

    private void dfs(TreeNode node, int target, LinkedList<Integer> path, List<List<Integer>> res) {
        if (node != null) {
            path.add(node.val);
            if (target == node.val && node.left == null && node.right == null) {
                res.add(new LinkedList<Integer>(path));
            } else {
                dfs(node.left, target - node.val, path, res);
                dfs(node.right, target - node.val, path, res);
            }
            path.removeLast();
        }
    }
}