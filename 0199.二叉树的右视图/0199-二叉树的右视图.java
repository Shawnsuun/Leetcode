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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> RSView = new ArrayList<Integer>();
        if (root == null) {
            return RSView;
        }
        
        Queue<TreeNode> cache1 = new LinkedList<TreeNode>();
        Queue<TreeNode> cache2 = new LinkedList<TreeNode>();
        cache1.offer(root);
        int bottomRightVal;

        while (!cache1.isEmpty()) {
            TreeNode curr = cache1.poll();
            if (curr.left != null) {
                cache2.offer(curr.left);
            }
            if (curr.right != null) {
                cache2.offer(curr.right);
            } 
            if (cache1.isEmpty()) {
                cache1 = cache2;
                cache2 = new LinkedList<TreeNode>();
                bottomRightVal = curr.val;
                RSView.add(bottomRightVal);
            }
        }
        return RSView;
    }
}