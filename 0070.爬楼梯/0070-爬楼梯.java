class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[]{1, 1};
        for (int i = 1; i < n; i ++) {
            dp[(i + 1) % 2] = dp[0] + dp[1];
        }
        return dp[n % 2];
    }
}