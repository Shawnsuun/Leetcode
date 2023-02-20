class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (e1, e2) -> nums1[e1[0]] + nums2[e1[1]] - nums1[e2[0]] - nums2[e2[1]]);
        for (int i = 0; i < Math.min(nums1.length, k); i ++) {
            int[] indexPair = new int[] {i, 0};
            pq.offer(indexPair);
        }

        List<List<Integer>> res = new LinkedList<>();
        while (k > 0 && !pq.isEmpty()) {
            int[] indexPair = pq.poll();
            List<Integer> pair = new LinkedList<>();
            pair.add(nums1[indexPair[0]]);
            pair.add(nums2[indexPair[1]]);
            res.add(pair);
            if (indexPair[1] < nums2.length - 1) {
                pq.offer(new int[]{indexPair[0], indexPair[1] + 1});
            }
            k --;
        }
        return res;
    }
}