class FreqStack {
    private Map<Integer, Integer> freqs;
    private Map<Integer, Deque<Integer>> groups;
    private int maxFreq;

    public FreqStack() {
        freqs = new HashMap<Integer, Integer>();    //key: element, val: frequency of element
        groups = new HashMap<Integer, Deque<Integer>>();    //key: frequency, val: elements of the frenquency
        maxFreq = 0;
    }
    
    public void push(int val) {
        freqs.put(val, freqs.getOrDefault(val, 0) + 1); 
        groups.putIfAbsent(freqs.get(val), new ArrayDeque<Integer>());
        groups.get(freqs.get(val)).push(val);
        maxFreq = Math.max(maxFreq, freqs.get(val));
    }
    
    public int pop() {
        int poped = groups.get(maxFreq).pop();
        freqs.put(poped, freqs.get(poped) - 1);
        if (groups.get(maxFreq).isEmpty()) {
            groups.remove(maxFreq); //eliminate empty deque, make every deque has element to pop
            maxFreq --;
        }
        return poped;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */