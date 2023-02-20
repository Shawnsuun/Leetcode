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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        
        int len = 0;
        ListNode len_search = head;
        while (len_search != null) {
            len_search = len_search.next;
            len += 1;
        }

        int count = 0;
        ListNode temp = sentinel;
        while (count < len - n) {
            temp = temp.next;
            count ++;
        }
        temp.next = temp.next.next;
        return sentinel.next;
    }
    
}