/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(-1);
        ListNode cur = sentinel;
        while (l1 != null && l2 != null) {
            int val1 = l1.val;
            int val2 = l2.val;
            cur.next = val1 < val2 ? l1 : l2;
            l1 = val1 < val2 ? l1.next : l1;
            l2 = val1 < val2 ? l2 : l2.next;
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return sentinel.next;
    }
}