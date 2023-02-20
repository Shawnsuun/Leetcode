/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private List<Integer> res = new ArrayList<>();
    
    public int[] reversePrint(ListNode head) {
        if (head != null) {
            reversePrint(head.next);
            res.add(head.val);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}