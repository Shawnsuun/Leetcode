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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> cache = new LinkedList<TreeNode>();
        cache.offer(root);
        int cur = 1;
        int next = 0;
        List<Integer>vals = new ArrayList<Integer>();
        while (!cache.isEmpty()) {
            TreeNode node = cache.poll();
            vals.add(node.val);
            cur --;
            if (node.left != null) {
                cache.offer(node.left);
                next ++;
            }
            if (node.right != null) {
                cache.offer(node.right);
                next ++;
            }
            if (cur == 0) {
                cur = next;
                next = 0;
                res.add(0, vals);
                vals = new ArrayList<Integer>();
            }
        }
        return res;
    }
}