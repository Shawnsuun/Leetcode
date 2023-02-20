class RecentCounter {
    private Queue<Integer> memory;

    public RecentCounter() {
        memory = new ArrayDeque<Integer>();
    }
    
    public int ping(int t) {
        memory.offer(t);
        while (t - memory.peek() > 3000) {
            memory.poll();
        }
        return memory.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */