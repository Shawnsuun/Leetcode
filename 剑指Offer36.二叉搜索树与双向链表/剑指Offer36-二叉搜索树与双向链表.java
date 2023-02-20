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
    private Node head = null;   //global variables
    private Node prev = null;
    
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
        if (node != null) {
            dfs(node.left);

            if (prev == null) { //inital edging case
                head = node;    
            } else {    //normal case
                prev.right = node; 
            }
            node.left = prev;
            prev = node;
            
            dfs(node.right);
        }
    }
}