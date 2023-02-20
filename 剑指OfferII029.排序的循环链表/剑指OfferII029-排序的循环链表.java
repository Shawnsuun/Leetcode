/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }

        Node node = head;
        while (node.next != head) {
            if (insertVal >= node.val && insertVal <= node.next.val) {
                break;
            }
            if (node.val > node.next.val && (insertVal >= node.val || insertVal <= node.next.val)) {
                break;
            }
            node = node.next;
        }
        Node next = node.next;
        node.next = new Node(insertVal);
        node.next.next = next;        
        return head;
    }
}








