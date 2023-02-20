class Solution {
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegrees = new HashMap<>();
        for (int[] seq : sequences) {
            for (int num : seq) {
                if (num < 1 || num > nums.length) {
                    return false;
                }
                graph.putIfAbsent(num, new HashSet<Integer>());
                inDegrees.putIfAbsent(num, 0);
            }
            for (int i = 1; i < seq.length; i ++) {
                int num1 = seq[i - 1];
                int num2 = seq[i];
                if (!graph.get(num1).contains(num2)) {
                    graph.get(num1).add(num2);
                    inDegrees.put(num2, inDegrees.get(num2) + 1);
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int key : inDegrees.keySet()) {
            if (inDegrees.get(key) == 0) {
                queue.offer(key);
            }
        }
        List<Integer> rebuild = new LinkedList<>();
        while (queue.size() == 1) {
            int num = queue.poll();
            rebuild.add(num);
            for (int next : graph.get(num)) {
                inDegrees.put(next, inDegrees.get(next) - 1);
                if (inDegrees.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }
        return rebuild.size() == nums.length ? true : false;
    }
}