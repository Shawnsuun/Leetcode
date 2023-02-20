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
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> nums = new ArrayList<Integer>();
        dfs(root, nums);
        TreeNode sentinel = new TreeNode();
        TreeNode node = sentinel;
        for (int num : nums) {
            sentinel.right = new TreeNode(num);
            sentinel = sentinel.right;
        }
        return node.right;
    }

    private void dfs(TreeNode node, List nums) {
        if (node != null) {
            dfs(node.left, nums);
            nums.add(node.val);
            dfs(node.right, nums);
        }
    }

}