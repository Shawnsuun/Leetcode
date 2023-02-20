class MedianFinder {
    private PriorityQueue<Integer> maxPQ;   //save smaller half numbers
    private PriorityQueue<Integer> minPQ;   //save larger half numbers

    /** initialize your data structure here. */
    public MedianFinder() {
        maxPQ = new PriorityQueue<Integer>((x, y) -> y - x);
        minPQ = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        if (maxPQ.size() - minPQ.size() == 1) { //stream size is odd
            maxPQ.offer(num);
            minPQ.offer(maxPQ.poll());
        } else {    //stream size is even
            minPQ.offer(num);
            maxPQ.offer(minPQ.poll());
        }
    }
    
    public double findMedian() {
        if (maxPQ.size() != minPQ.size()) {
            return (double)maxPQ.peek();
        }
        return (double)(maxPQ.peek() + minPQ.peek()) / 2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */