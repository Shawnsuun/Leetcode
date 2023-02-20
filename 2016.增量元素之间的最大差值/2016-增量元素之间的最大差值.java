class Solution {
    public int maximumDifference(int[] nums) {
        int minPrefix = nums[0];
        int res = -1;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] - minPrefix > 0) {
                res = Math.max(res, nums[i] - minPrefix);
            } else {
                minPrefix = nums[i];
            }
        }
        return res;
    }
}