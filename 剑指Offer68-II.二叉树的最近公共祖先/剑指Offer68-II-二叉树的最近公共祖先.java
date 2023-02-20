/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {   //root is null, return null
            return root;    //root = p or q, return root
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p , q);
        if (left == null && right == null) {    //p or q not found in both side
            return null;
        }
        if (right == null) {    //p or q is not found in right side, return left
            return left;
        }
        if (left == null) { //p or q is not found in left side, return right
            return right;
        }
        return root;    //p, q are in different side of root, root is the common ancestor
    }
}