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
class BSTIterator {
    Deque<TreeNode> deque;
    TreeNode cur;

    public BSTIterator(TreeNode root) {
        deque = new LinkedList<>();
        cur = root;
    }
    
    public int next() {
        while (cur != null) {
            deque.push(cur);
            cur = cur.left;
        }
        cur = deque.pop();
        int next = cur.val;
        cur = cur.right;    
        return next;
    }
    
    public boolean hasNext() {
        return cur != null || !deque.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */