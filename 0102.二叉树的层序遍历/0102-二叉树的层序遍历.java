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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> cache = new LinkedList<TreeNode>();
        cache.offer(root);
        List<Integer>vals = new ArrayList<Integer>();
        while (!cache.isEmpty()) {
            int size = cache.size();
            for (int i = 0; i < size; i ++) {
                TreeNode node = cache.poll();
                vals.add(node.val);
                if (node.left != null) {
                    cache.offer(node.left);
                    
                }
                if (node.right != null) {
                    cache.offer(node.right);
                }
            }
            res.add(vals);
            vals = new ArrayList<Integer>();
        }
        return res;
    }
}