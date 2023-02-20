class MovingAverage {
    Queue<Integer> queue;
    int capacity;
    int sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        capacity = size;
        sum = 0;
    }
    
    public double next(int val) {
        if (queue.size() == capacity) {
            sum -= queue.poll();
        }
        queue.offer(val);
        sum += val;
        return (double) sum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */