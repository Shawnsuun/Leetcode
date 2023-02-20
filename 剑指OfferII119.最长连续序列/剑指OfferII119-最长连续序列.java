class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> parents = new HashMap<>();
        Map<Integer, Integer> counts = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            parents.put(num, num);
            counts.put(num, 1);
            set.add(num);
        }
        for (int num : nums) {
            if (set.contains(num - 1)) {
                union(parents, counts, num - 1, num);
            }
            if (set.contains(num + 1)) {
                union(parents, counts, num, num + 1);
            }
        }
        int longest = 0;
        for (int num : set) {
            longest = Math.max(longest, counts.get(num));
        }
        return longest;
    }

    private int findRoot(Map<Integer, Integer> parents, int i) {
        while (parents.get(i) != i) {
            i = parents.get(i);
        }
        return parents.get(i);
    }

    private void union(Map<Integer, Integer> parents, Map<Integer, Integer> counts, int i, int j) {
        int rootI = findRoot(parents, i);
        int rootJ = findRoot(parents, j);
        if (rootI != rootJ) {
            parents.put(rootJ, rootI);
            int countI = counts.get(rootI);
            int countJ = counts.get(rootJ);
            counts.put(rootI, countI + countJ);
        }
    }
}