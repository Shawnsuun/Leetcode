class MaxQueue {
    private Deque<Integer> deque;
    private Deque<Integer> maxDeque;

    public MaxQueue() {
        deque = new LinkedList<>();
        maxDeque = new LinkedList<>();
    }
    
    public int max_value() {
        if (deque.isEmpty()) {
            return -1;
        }
        return maxDeque.peekFirst();
    }
    
    public void push_back(int value) {
        deque.addLast(value);
        while (!maxDeque.isEmpty() && maxDeque.peekLast() < value) {
            maxDeque.removeLast();
        }
        maxDeque.addLast(value);
    }
    
    public int pop_front() {
        if (deque.isEmpty()) {
            return -1;
        }
        int popped = deque.removeFirst();
        if (popped == maxDeque.peekFirst()) {
            maxDeque.removeFirst();
        }
        return popped;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */