/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        //divide original ListNode
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode fast = sentinel;
        ListNode slow = sentinel;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow;
        slow = slow.next;
        temp.next = null;
        ListNode head1 = head;
        ListNode head2 = reverse(slow);
        
        //re-order
        ListNode cur = sentinel;
        while (head2 != null) {
            cur.next = head1;
            cur = head1;
            head1 = head1.next;
            cur.next = head2;
            cur = head2;
            head2 = head2.next;
        }
        if (head1 != null) {
            cur.next = head1;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}