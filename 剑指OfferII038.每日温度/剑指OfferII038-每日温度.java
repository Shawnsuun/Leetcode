class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        //stack saves temperature indexes
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i ++) {
            while (!deque.isEmpty() && temperatures[i] > temperatures[deque.peek()]) {
                int popped = deque.pop();
                res[popped] = i - popped;
            }
            //push i if stack is empty, or i is smaller than stack top num
            deque.push(i);
        }
        return res;
    }
}