class CQueue {
    private Deque<Integer> deque1;
    private Deque<Integer> deque2;

    public CQueue() {
        deque1 = new LinkedList<>();
        deque2 = new LinkedList<>();
    }
    
    public void appendTail(int value) {
        deque1.push(value);
    }
    
    public int deleteHead() {
        if (deque1.isEmpty() && deque2.isEmpty()) {
            return -1;
        }
        if (deque2.isEmpty()) {
            while (!deque1.isEmpty()) {
                deque2.push(deque1.pop());
            }
        }
        return deque2.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */