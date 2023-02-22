/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        //insert copied node after each node
        Node node = head;
        while (node != null) {
            Node copied = new Node(node.val);
            copied .next = node.next;
            node.next = copied ;
            node = copied .next;
        }

        //connect copied node with responding random node
        node = head;
        while (node != null) {
            Node copied  = node.next;
            copied .random = node.random == null ? null : node.random.next;
            node = copied .next;
        }

        //divide original node and copied node
        node = head;
        Node sentinel = new Node(0);
        sentinel.next = node.next;
        while (node != null) {
            Node copied = node.next;
            node.next = copied.next;
            node = node.next;
            copied.next = node == null ? null : node.next;
        }
        return sentinel.next;
    }
}