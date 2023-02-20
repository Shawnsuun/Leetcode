/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode CountA = headA;
        ListNode CountB = headB;
        while (CountA != null) {
            CountA = CountA.next;
            lenA ++;
        }
        while (CountB != null) {
            CountB = CountB.next;
            lenB ++;
        }
        int diff = lenA - lenB;
        ListNode longHead = diff >= 0 ? headA : headB;
        ListNode shortHead = diff >= 0 ? headB : headA;
        for (int i = 0; i < Math.abs(diff); i ++) {
            longHead = longHead.next;
        }
        while (longHead != null) {
            if (longHead == shortHead) {
                return longHead;
            }
            longHead = longHead.next;
            shortHead = shortHead.next;   
        }
        return null;
    }
}