class Solution {
    public int pivotIndex(int[] nums) {
        int[] sums = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i ++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        int sum = sums[sums.length - 2];
        for (int i = 1; i <= nums.length; i ++) {
            if (sums[i - 1] == sum - sums[i]) {
                return i - 1;
            }
        }
        return -1;
    }
}