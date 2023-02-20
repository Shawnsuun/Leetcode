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
    public int maxPathSum(TreeNode root) {
        int[] maxPath = {Integer.MIN_VALUE};
        getMaxPath(root, maxPath);
        return maxPath[0];
    }

    private int getMaxPath(TreeNode root, int[] maxPath) {
        if (root == null) {
            return 0;
        }
        int leftMax = Math.max(getMaxPath(root.left, maxPath), 0);
        int rightMax = Math.max(getMaxPath(root.right, maxPath), 0);
        //max path of a certain node
        int nodePath = root.val + leftMax + rightMax;
        //update maxPath(Core)
        maxPath[0] = Math.max(maxPath[0], nodePath);
        //get a max path all the way down to the leave
        return root.val + Math.max(leftMax, rightMax);
    }
}