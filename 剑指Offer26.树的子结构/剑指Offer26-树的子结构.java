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
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        TreeNode subRoot = getSubRoot(A, B.val);
        if (subRoot == null) {
            return false;
        }
        Deque<TreeNode> stackA = new ArrayDeque<>();
        Deque<TreeNode> stackB = new ArrayDeque<>();
        TreeNode nodeA = subRoot;
        TreeNode nodeB = B;
        while ((!stackA.isEmpty() || nodeA != null) && (!stackB.isEmpty() || nodeB != null)) {
            while (nodeA != null && nodeB != null) {
                stackA.push(nodeA);
                stackB.push(nodeB);          
                nodeA = nodeA.left;
                nodeB = nodeB.left;
                if (nodeA == null && nodeB != null) {
                    return false;
                }                      
            }
            nodeA = stackA.pop();
            nodeB = stackB.pop();
            if (nodeA.val != nodeB.val) {
                return false;
            }
            nodeA = nodeA.right;
            nodeB = nodeB.right;
            if (nodeA == null && nodeB != null) {
                return false;
            }       
        }
        return true;
    }

    private TreeNode getSubRoot(TreeNode A, int rootVal) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = A;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (node.val == rootVal) {
                TreeNode subRoot = node;
                return subRoot;
            }
            node = node.right;
        }
        return null;
    }
}