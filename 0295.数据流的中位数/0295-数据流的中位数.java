class MedianFinder {
    private PriorityQueue<Integer> minpq;
    private PriorityQueue<Integer> maxpq;

    public MedianFinder() {
        minpq = new PriorityQueue<>();
        maxpq = new PriorityQueue<>((a, b) -> b - a);
    }
    
    public void addNum(int num) {
        if (maxpq.isEmpty() || num <= maxpq.peek()) {
            maxpq.offer(num);
        } else {
            minpq.offer(num);
        }
        if (maxpq.size() > minpq.size() + 1) {
            int polled = maxpq.poll();
            minpq.offer(polled);
        }
        if (minpq.size() > maxpq.size()) {
            int polled = minpq.poll();
            maxpq.offer(polled);
        }
    }
    
    public double findMedian() {
        if (maxpq.size() == minpq.size()) {
            return (double)(maxpq.peek() + minpq.peek()) / 2;
        }
        return maxpq.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */