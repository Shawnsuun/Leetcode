class MyQueue {
    private Deque<Integer> deque1;
    private Deque<Integer> deque2;

    public MyQueue() {
        deque1 = new LinkedList<>();
        deque2 = new LinkedList<>();
    }
    
    public void push(int x) {
        deque1.push(x);
    }
    
    public int pop() {
        if (deque2.isEmpty()) {
            while (!deque1.isEmpty()) {
                deque2.push(deque1.pop());
            }
        }
        return deque2.pop();
    }
    
    public int peek() {
        if (deque2.isEmpty()) {
            while (!deque1.isEmpty()) {
                deque2.push(deque1.pop());
            }
        }
        return deque2.peek();
    }
    
    public boolean empty() {
        return deque1.isEmpty() && deque2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */