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
    //pre-order dfs iterator
    public class BSTIterator {
        TreeNode cur;
        Deque<TreeNode> deque;

        public BSTIterator(TreeNode root) {
            cur = root;
            deque = new LinkedList<>();
        }

        public boolean hasNext() {
            return cur != null || !deque.isEmpty();
        }

        public int next() {
            while (cur != null) {
                deque.push(cur);
                cur = cur.left;
            }
            cur = deque.pop();
            int val = cur.val;
            cur = cur.right;
            return val;
        }
    }

    //reversed pre-order dfs iterator
    public class BSTIteratorReversed {
        TreeNode cur;
        Deque<TreeNode> deque;

        public BSTIteratorReversed(TreeNode root) {
            cur = root;
            deque = new LinkedList<>();
        }

        public boolean hasPrev() {
            return cur != null || !deque.isEmpty();
        }

        public int prev() {
            while (cur != null) {
                deque.push(cur);
                cur = cur.right;
            }
            cur = deque.pop();
            int val = cur.val;
            cur = cur.left;
            return val;
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        BSTIterator iterNext = new BSTIterator(root);
        BSTIteratorReversed iterPrev = new BSTIteratorReversed(root);
        int left = iterNext.next();
        int right = iterPrev.prev();
        while (left < right) {
            if (left + right == k) {
                return true;
            } else if (left + right > k) {
                right = iterPrev.prev();
            } else {
                left = iterNext.next();
            }
        }
        return false;
    }
}