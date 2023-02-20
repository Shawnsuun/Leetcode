class Solution {
    private int size;
    private PriorityQueue<Map.Entry<Integer, Integer>> heap;
    
    public int[] topKFrequent(int[] nums, int k) {
        size = k;
        heap = new PriorityQueue<Map.Entry<Integer, Integer>>(
            (e1, e2) -> e1.getValue() - e2.getValue()
        );
        HashMap<Integer, Integer> frequents = new HashMap<Integer, Integer>();
        int[] res = new int[k];
        
        for (int num : nums) {
            frequents.put(num, frequents.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> mapping : frequents.entrySet()) {
            add(mapping);
        }
        int i = k - 1;
        for (Map.Entry<Integer, Integer> mapping : heap) {
            res[i] = mapping.getKey();
            i --;
        }
        return res;
    }

    private void add(Map.Entry<Integer, Integer> mapping) {
        if (heap.size() < size) {
            heap.offer(mapping);
        } else if (mapping.getValue() > heap.peek().getValue()) {
            heap.poll();
            heap.offer(mapping);
        }
    }
}