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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(-1);
        ListNode node = sentinel;
        while (l1 != null && l2 != null) {
            int val1 = l1.val, val2 = l2.val;
            node.next = val1 < val2 ? l1 : l2; 
            l1 = val1 < val2 ? l1.next : l1;
            l2 = val1 < val2 ? l2 : l2.next;
            node = node.next;
        }
        node.next = l1 == null ? l2 : l1;
        return sentinel.next;
    }
}