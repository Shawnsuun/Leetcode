class Solution {
    public int minIncrementForUnique(int[] nums) {
        int[] counts = new int[100001];
        int steps = 0;
        for (int num : nums) {
            counts[num] += 1;
        }
        for (int i = 0; i < 100000; i ++) {
            if (counts[i] > 1) {
                counts[i + 1] += counts[i] - 1;
                steps += counts[i] - 1;
                counts[i] = 1;
            }
        }
        if (counts[100000] > 1) {
            steps += counts[100000] * (counts[100000] - 1) / 2;
        }
        return steps;
    }
}