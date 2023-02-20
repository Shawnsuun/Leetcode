class Solution {
    public int maxSubArray(int[] nums) {
        int MaxSum = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            MaxSum = Math.max(nums[i] + MaxSum, nums[i]);
            res = Math.max(res, MaxSum);
        }
        return res;
    }
}