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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> cache1 = new LinkedList<TreeNode>();
        Queue<TreeNode> cache2 = new LinkedList<TreeNode>();
        
        cache1.offer(root);
        int row_max = Integer.MIN_VALUE;

        while (!cache1.isEmpty()) {
            TreeNode curr = cache1.poll();

            if (curr.left != null) {
                cache2.offer(curr.left);
            }
            if (curr.right != null) {
                cache2.offer(curr.right);
            }

            row_max = Math.max(row_max, curr.val);

            if (cache1.isEmpty()) {
                res.add(row_max);
                cache1 = cache2;
                cache2 = new LinkedList<TreeNode>();
                row_max = Integer.MIN_VALUE;
            } 
        }
        return res;
    }
}