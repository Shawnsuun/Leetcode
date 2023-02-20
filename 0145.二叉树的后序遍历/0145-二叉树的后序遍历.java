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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<Integer>();
        Stack<TreeNode> cache = new Stack<TreeNode>();
        TreeNode prev = null;
        TreeNode curr = root;

        while (!cache.isEmpty() || curr != null) {
            while (curr != null) {
                cache.push(curr);
                curr = curr.left;
            }
            curr = cache.peek();
            //The right node exists and is not visited
            if (curr.right != null && curr.right != prev) {
                //curr stay in stack, switch curr to the right node
                curr = curr.right;
            } else {
                //If nothing on the right, stack pop, add to list, curr node become null
                nodes.add(curr.val);
                cache.pop();
                prev = curr;
                curr = null;
            }
        }
        return nodes;
    }
}