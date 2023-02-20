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
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode sentinel = new TreeNode(0);
        TreeNode cur = sentinel;
        TreeNode node = root;
        while (node != null || !deque.isEmpty()) {
            while (node != null) {
                deque.push(node);
                node = node.left;
            }
            node = deque.pop();
            cur.right = node;
            cur = cur.right;
            node = node.right;
            cur.left = null;
            cur.right = null;            
        }
        return sentinel.right;
    }
}