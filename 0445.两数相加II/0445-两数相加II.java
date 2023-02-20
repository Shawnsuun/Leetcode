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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode revList1 = reverseLinkedList(l1);
        ListNode revList2 = reverseLinkedList(l2);       
        ListNode sentinel = new ListNode(0, null);
        ListNode sumNode = sentinel;
        
        int carry = 0;
        while (revList1 != null || revList2 != null) {
            int val1 = revList1 != null ? revList1.val : 0;
            int val2 = revList2 != null ? revList2.val : 0;
            int sum = val1 + val2 + carry;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            sumNode.next = new ListNode(sum, null);
            sumNode = sumNode.next;
            revList1 = revList1 != null ? revList1.next : null;
            revList2 = revList2 != null ? revList2.next : null;
        }

        //Add addtional ListNode if left 1 carry after all nums in two lists are added.
        if (carry == 1) {
            sumNode.next = new ListNode(1, null);
        }

        return reverseLinkedList(sentinel.next);
    }

    //Help method to reverse linked list
    private ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}