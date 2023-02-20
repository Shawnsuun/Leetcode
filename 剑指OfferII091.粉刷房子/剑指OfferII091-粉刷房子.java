class Solution {
    public int minCost(int[][] costs) {
        int len = costs.length;
        int[][] dp = new int[2][3];
        for (int i = 0; i < len; i ++) {
            dp[(i + 1) % 2][0] = Math.min(dp[i % 2][1], dp[i % 2][2]) + costs[i][0];
            dp[(i + 1) % 2][1] = Math.min(dp[i % 2][0], dp[i % 2][2]) + costs[i][1];
            dp[(i + 1) % 2][2] = Math.min(dp[i % 2][0], dp[i % 2][1]) + costs[i][2];
        }
        return Math.min(Math.min(dp[len % 2][0], dp[len % 2][1]), dp[len % 2][2]);
    }
}