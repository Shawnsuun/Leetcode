class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<Integer>();
        int[] res = new int[nums.length - k + 1];
        //before window is formed
        for (int i = 0; i < k; i ++) {
            //make sure the deque is in a decreasing order
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        //after window is formed
        res[0] = deque.peekFirst();
        for (int i = k; i < nums.length; i ++) {
            //num to be removed from the window is at queue head
            if (deque.peekFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);    
            res[i - k + 1] = deque.peekFirst();        
        }
        return res;
    }
}