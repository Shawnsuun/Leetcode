/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        flattenGetTail(head);
        return head;
    }   

    private Node flattenGetTail(Node head) {
        Node node = head;
        Node tail = null;
        while (node != null) {
            Node next = node.next;
            //Find if child exists
            if (node.child != null) {
                Node child = node.child;
                //childTail is the end node of the tail
                Node childTail = flattenGetTail(child);
                //Disconnect node and its child
                node.child = null;
                //Reconnect node & its child by prev & next
                node.next = child;
                child.prev = node;
                //Reconnect childTail and next node, skip if next is null               
                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }
                //tail is the tail of the child
                tail = childTail;
            } else {
                tail = node;
            }
            node = next;
        }
        return tail;
    }
}