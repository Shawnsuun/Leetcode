class MinStack {
    private Deque<Integer> deque;
    private Deque<Integer> minDeque;

    public MinStack() {
        deque = new ArrayDeque<>();
        minDeque = new ArrayDeque<>();
    }
    
    public void push(int val) {
        deque.push(val);
        if (minDeque.isEmpty() || val <= minDeque.peek()) {
            minDeque.push(val);
        }
    }
    
    public void pop() {
        int val = deque.pop();
        if (val == minDeque.peek()) {
            minDeque.pop();
        }
    }
    
    public int top() {
        return deque.peek();
    }
    
    public int getMin() {
        return minDeque.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */