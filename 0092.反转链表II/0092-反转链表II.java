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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode node = sentinel;
        for (int i = 0; i < left - 1; i ++) {
            node = node.next;
        }
        ListNode headEnd = node;
        ListNode revHead = node.next;
        for (int i = 0; i < right - left + 1; i ++) {
            node = node.next;
        }
        ListNode revEnd = node;
        ListNode tailStart = node.next;
        revEnd.next = null;

        ListNode prev = tailStart;
        ListNode cur = revHead;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        headEnd.next = prev;
        return sentinel.next;
    }

}