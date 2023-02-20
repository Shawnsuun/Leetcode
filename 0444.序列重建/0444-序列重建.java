class Solution {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
        Map<Integer, Integer> inDegrees = new HashMap<Integer, Integer>();
        for (List<Integer> sequence : sequences) {
            for (int num : sequence) {
                if (num > nums.length) {
                    return false;
                }
                graph.putIfAbsent(num, new HashSet<Integer>());
                inDegrees.putIfAbsent(num, 0);
            }
            for (int i = 0; i < sequence.size() - 1; i ++) {
                int num1 = sequence.get(i);
                int num2 = sequence.get(i + 1);
                if (!graph.get(num1).contains(num2)) {
                    graph.get(num1).add(num2);
                    inDegrees.put(num2, inDegrees.get(num2) + 1);
                }
            }
        }
        if (graph.size() != nums.length) {
            return false;
        }        

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int key : graph.keySet()) {
            if (inDegrees.get(key) == 0) {
                queue.offer(key);
            }
        }
        
        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                return false;
            }
            int numSmall = queue.poll();
            for (int numLarge : graph.get(numSmall)) {
                inDegrees.put(numLarge, inDegrees.get(numLarge) - 1);
                if (inDegrees.get(numLarge) == 0) {
                    queue.offer(numLarge);
                }
            }           
        }
        return true;
    }
}