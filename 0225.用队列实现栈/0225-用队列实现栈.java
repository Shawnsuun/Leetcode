class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
        queue1.offer(x);
    }
    
    public int pop() {
        int cur = -1;
        while (!queue1.isEmpty()) {
            cur = queue1.poll();
            if (!queue1.isEmpty()) {
                queue2.offer(cur);
            }
        }
        queue1 = queue2;
        queue2 = new LinkedList<>();
        return cur;
    }
    
    public int top() {
        int cur = -1;
        while (!queue1.isEmpty()) {
            cur = queue1.poll();
            queue2.offer(cur);
        }
        queue1 = queue2;
        queue2 = new LinkedList<>();
        return cur;
    }
    
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */