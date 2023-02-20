class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //PQ saves int[] index of pairs
        Queue<int[]> heap = new PriorityQueue<int[]>(
            (e1, e2) -> nums1[e1[0]] +nums2[e1[1]] - nums1[e2[0]] - nums2[e2[1]]
        );
        //each num index in nums1 and first num index in nums2 form pairs and enque
        for (int i = 0; i < Math.min(nums1.length, k); i ++) {
            heap.offer(new int[] {i, 0});
        }
        
        List<List<Integer>> pairs = new ArrayList<List<Integer>>(); 
        //the while loop will run k times at most
        while (k > 0 && !heap.isEmpty()) {
            int[] pairIndex = heap.poll();
            pairs.add(Arrays.asList(nums1[pairIndex[0]], nums2[pairIndex[1]]));
            //in case nums2.length < k
            if (pairIndex[1] < nums2.length - 1) {
                heap.offer(new int[] {pairIndex[0], pairIndex[1] + 1});
            }
            k --; 
        }
        return pairs;
    }
}