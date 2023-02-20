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
    /** Maintain an int for the class, update during recursion,
    use min_value in case there is a single node with negative val. */ 
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        gainMaxSum(root);
        return maxSum;
    }

    private int gainMaxSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        //Updating the class variable maxSum
        int nodeVal = node.val;
        int leftMax = Math.max(gainMaxSum(node.left), 0);
        int rightMax = Math.max(gainMaxSum(node.right), 0);
        int nodeMaxPath = nodeVal + leftMax + rightMax;
        maxSum = Math.max(maxSum, nodeMaxPath);
        //return the maxvalue that the node can provide for other nodes
        return node.val + Math.max(leftMax, rightMax);
    }
}