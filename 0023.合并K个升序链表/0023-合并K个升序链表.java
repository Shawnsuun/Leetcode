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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return mergeLists(lists, 0, lists.length);
    }

    //merge multiple ListNodes in a list
    private ListNode mergeLists(ListNode[] lists, int start, int end) {
        //only one ListNode in the list        
        if (start + 1 == end) {
            return lists[start];
        }

        int mid = (start + end) / 2;
        //merge index start ~ mid - 1
        ListNode head1 = mergeLists(lists, start, mid);
        //merge index start ~ mid - 1
        ListNode head2 = mergeLists(lists, mid, end);
        return mergeTwo(head1, head2);
    }

    //merge two ListNodes
    private ListNode mergeTwo(ListNode head1, ListNode head2) {
        ListNode sentinel = new ListNode();
        ListNode cur = sentinel;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        cur.next = head1 == null ? head2 : head1;
        return sentinel.next;
    }
}