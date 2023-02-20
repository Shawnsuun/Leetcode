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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> cache = new Stack<TreeNode>();
        List<Integer> nodes = new ArrayList<Integer>();
        TreeNode curr = root;

        while (!cache.isEmpty() || curr != null) {
            while (curr != null) {
                cache.push(curr);
                nodes.add(curr.val);
                curr = curr.left;
            }
            curr = cache.pop();
            curr = curr.right;
        }
        return nodes;
    }
}