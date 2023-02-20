/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
            ListNode sentinel = new ListNode(-1);
            sentinel.next = head;
            ListNode fast = sentinel;
            ListNode slow = sentinel;
            while (fast != slow || fast == sentinel) {
                if (fast == null || fast.next == null) {
                    return null;
                }
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode start = sentinel;
            while (start != slow) {
                start = start.next;
                slow = slow.next;
            }
            return start;
    }
}