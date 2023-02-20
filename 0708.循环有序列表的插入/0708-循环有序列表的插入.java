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
        //empty head
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }

        Node cur = head;
        //Traverse the cycle
        while (cur.next != head) {
            //normal insert position found 
            if (insertVal >= cur.val && insertVal <= cur.next.val) {
                break;
            }
            //head/tail insert position found
            if (cur.val > cur.next.val && (insertVal >= cur.val || insertVal <= cur.next.val)) {
                break;
            }
            cur = cur.next;        
        }
        //insert node
        Node next = cur.next;
        cur.next = new Node(insertVal);
        cur.next.next = next;
        return head;
    }
}