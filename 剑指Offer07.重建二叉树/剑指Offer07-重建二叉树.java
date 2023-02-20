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
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = inorder.length;
        map = new HashMap<>();
        for (int i = 0; i < len; i ++) {
            map.put(inorder[i], i); //key: node.val; val: inorder index
        }
        return helper(preorder, inorder, 0, len - 1, 0, len - 1);
    }

    //preOrder: [ root | leftTree | rightTree ] 
    //inOrder:  [ leftTree | root | rightTree ]
    private TreeNode helper(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preLeft]);    //root is left most index from preorder 
        int inRoot = map.get(preorder[preLeft]);
        int leftTreeSize = inRoot - inLeft;     //get left tree size from inorder
        root.left = helper(preorder, inorder, preLeft + 1, preLeft + leftTreeSize, inLeft, inRoot - 1);
        root.right = helper(preorder, inorder, preLeft + leftTreeSize + 1, preRight, inRoot + 1, inRight);
        return root;
    }
}