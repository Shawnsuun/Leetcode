class Solution {
    public int rob(int[] nums) {
        //dp function : f(n) = max(f(n - 2) + nums[n], f(n - 1))
        int res1 = dp(nums, 0, nums.length - 2);
        int res2 = dp(nums, 1, nums.length - 1);
        return Math.max(res1, res2);
    }

    private int dp(int[] nums, int start, int end) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[end - start + 1];
        dp[0] = nums[start];
        if (start < end) {
            dp[1] = Math.max(nums[start + 1], nums[start]);
        }
        for (int i = 2; i < end - start + 1; i ++) {
            dp[i] = Math.max(dp[i - 2] + nums[i + start], dp[i - 1]);
        }
        return dp[end - start];
    }
}