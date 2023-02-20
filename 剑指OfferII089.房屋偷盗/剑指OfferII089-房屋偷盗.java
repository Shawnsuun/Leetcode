class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[2];
        dp[1] = nums[0];
        for (int i = 1; i < len; i ++) {
            dp[(i + 1) % 2] = Math.max(dp[(i - 1) % 2] + nums[i], dp[i % 2]);
        }
        return dp[len % 2];
    }
}