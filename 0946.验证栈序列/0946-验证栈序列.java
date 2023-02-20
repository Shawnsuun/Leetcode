class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;
        for (int i = 0; i < pushed.length; i ++) {
            deque.push(pushed[i]);
            while (!deque.isEmpty() && popped[index] == deque.peek()) {
                deque.pop();
                index ++;
            }
        }
        return deque.isEmpty();
    }
}