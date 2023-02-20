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
class CBTInserter {
    private Queue<TreeNode> cache;
    private TreeNode rootNode;
    private TreeNode currNode;

    public CBTInserter(TreeNode root) {
        cache = new LinkedList<TreeNode>();
        rootNode = root;
        cache.offer(root);
        while (cache.peek().left != null && cache.peek().right != null) {
            TreeNode currNode = cache.poll();
            cache.offer(currNode.left);
            cache.offer(currNode.right);
        } 
    }
    
    public int insert(int val) {
        TreeNode currNode = cache.peek();
        if (currNode.left == null) {
            currNode.left = new TreeNode(val);
        } else if (currNode.right == null) {
            currNode.right = new TreeNode(val);
            cache.offer(currNode.left);
            cache.offer(currNode.right);
            cache.poll();
        }
        return currNode.val;
    }
    
    public TreeNode get_root() {
        return rootNode;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */