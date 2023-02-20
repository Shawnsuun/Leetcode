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
        Map<Node, Node> map = new HashMap<Node, Node>();
        Node sentinel = new Node(0);
        Node cur = sentinel;
        Node temp = head;
        while (temp != null) {
            Node node = new Node(temp.val);
            map.put(temp, node);
            temp = temp.next;
            cur.next = node;
            cur = node;
        } 
        cur = sentinel.next;
        temp = head;
        while (temp != null) {
            cur.random = map.get(temp.random);
            temp = temp.next;
            cur = cur.next;
        }
        return sentinel.next;
    }
}