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
        ListNode node1 = l1, node2 = l2;
        Deque<ListNode> deque1 = new LinkedList<>();
        Deque<ListNode> deque2 = new LinkedList<>();
        while  (node1 != null) {
            deque1.push(node1);
            node1 = node1.next;
        }
        while  (node2 != null) {
            deque2.push(node2);
            node2 = node2.next;
        }
        ListNode cur = null;
        int carry = 0;
        while (!deque1.isEmpty() || !deque2.isEmpty()) {
            int num1 = deque1.peek() == null ? 0 : deque1.pop().val;
            int num2 = deque2.peek() == null ? 0 : deque2.pop().val;
            int sum = num1 + num2 + carry;
            carry = sum >= 10 ? 1 : 0;
            sum = sum >= 10 ? sum - 10 : sum;            
            ListNode prev = new ListNode(sum);
            prev.next = cur;
            cur = prev;
        }
        if (carry == 1) {
            ListNode prev = new ListNode(1);
            prev.next = cur;
            cur = prev;
        }    
        return cur;        
    }
}