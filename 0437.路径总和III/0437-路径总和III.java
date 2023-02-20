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
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int count = rootSum(root, targetSum);
        count += pathSum(root.left, targetSum);
        count += pathSum(root.right, targetSum);
        return count;
    }

    private int rootSum(TreeNode root, long targetSum) {
        int count = 0;
        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (targetSum - val == 0) {
            count ++;
        }
        count += rootSum(root.left, targetSum - val);
        count += rootSum(root.right, targetSum - val);
        return count;
    }
}