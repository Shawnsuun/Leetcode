/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    Node prev = null;
    Node head = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        prev.right = head;
        head.left = prev;
        return head;
    }

    private void dfs(Node node) {
        if (node == null) {
             return;
        }
        dfs(node.left);

        if (prev == null) {
            head = node;    //find the head node
        } else {
            prev.right = node;   //prev -> node
        }
        node.left = prev;   //prev <- node
        prev = node;

        dfs(node.right);
    }
}