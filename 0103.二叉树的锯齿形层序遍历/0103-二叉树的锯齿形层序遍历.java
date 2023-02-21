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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }        
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        boolean reverse = false;
        while (!deque.isEmpty()) {
            int size = deque.size();
            LinkedList<Integer> layer = new LinkedList<>();
            for (int i = 0; i < size; i ++) {
                TreeNode node = null;
                node = deque.poll();
                if (reverse) {
                    layer.addFirst(node.val);
                } else {
                    layer.addLast(node.val);
                }
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            reverse = !reverse;
            res.add(layer);
        }
        return res;
    }
}