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
    public int kthLargest(TreeNode root, int k) {
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (!deque.isEmpty() || node != null) {
            while (node != null) {
                deque.push(node);
                node = node.right;
            }
            node = deque.pop();
            k --;
            if (k == 0) {
                return node.val;
            }
            node = node.left;
        }
        return -1;
    }
}