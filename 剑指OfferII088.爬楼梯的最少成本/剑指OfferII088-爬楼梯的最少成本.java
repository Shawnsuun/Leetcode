class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[2];
        dp[1] = cost[0];
        for (int i = 1; i < len; i ++) {
            dp[(i + 1) % 2] = Math.min(dp[0], dp[1]) + cost[i];
        }
        return Math.min(dp[0], dp[1]);
    }
}