class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        for (int key : count.keySet()) {
            pq.offer(new int[]{key, count.get(key)});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        for (int i = 0; i < k; i ++) {
            res[i] = pq.poll()[0];
        }
        return res;
    }
}