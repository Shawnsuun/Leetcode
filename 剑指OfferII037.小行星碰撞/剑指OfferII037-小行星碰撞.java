class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> deque = new LinkedList<>();
        for (int ast : asteroids) {
            if (ast > 0) {
                deque.push(ast);
            } else {
                //stack is not empty, current neg ast destroy positive asts in stack top
                while (!deque.isEmpty() && deque.peek() > 0 && deque.peek() + ast < 0) {
                    int popped = deque.pop();    
                }
                //current neg ast and positive ast in stack top have equal size, destroy each other
                if (!deque.isEmpty() && deque.peek() > 0 && deque.peek() + ast == 0) {
                    deque.pop();
                    continue;
                }
                //empty stack, or current ast and ast in stack top are both neg, cur ast push in stack
                if (deque.isEmpty() || (!deque.isEmpty() && deque.peek() < 0 && ast < 0)) {
                    deque.push(ast);
                }
            }
        }
        int[] res = new int[deque.size()];
        for (int i = deque.size() - 1; i >= 0; i --) {
            res[i] = deque.pop();
        }
        return res;
    }
}