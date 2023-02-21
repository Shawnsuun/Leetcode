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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(root, targetSum, new LinkedList<>(), res);
        return res;
    }

    private void dfs(TreeNode root, int targetSum,  LinkedList<Integer> path, List<List<Integer>> res){
        if (root != null) {
            path.add(root.val);
            if (targetSum == root.val && root.left == null && root.right == null) {
                res.add(new LinkedList<>(path));
            } else {
                dfs(root.left, targetSum - root.val, path, res);
                dfs(root.right, targetSum - root.val, path, res);
            }
            path.removeLast();
        }
    }
}