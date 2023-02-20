class Solution {
    public int pivotIndex(int[] nums) {
        int[] sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i ++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        for (int i = 1; i < sums.length; i ++) {
            if (sums[i - 1] == sums[sums.length - 1] - sums[i]) {
                return i - 1;
            }
        }
        return -1;
    }
}