class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int j = 0;  //index for pushed num
        for (int i = 0; i < pushed.length; i ++) {     //i: index for popped num
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j ++;
            }
        }
        return stack.isEmpty();
    }
}