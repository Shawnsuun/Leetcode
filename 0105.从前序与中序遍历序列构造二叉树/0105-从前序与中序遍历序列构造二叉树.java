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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i ++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, preorder.length, 0, inorder.length, map);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int preEnd, 
        int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preStart == preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRootIndex = map.get(preorder[preStart]);
        int leftSize = inRootIndex - inStart;
        root.left = helper(preorder, inorder, preStart + 1, preStart + leftSize + 1, 
            inStart, inRootIndex, map);
        root.right = helper(preorder, inorder, preStart + leftSize + 1, preEnd, 
            inRootIndex + 1, inEnd, map);
        return root;
    }
}