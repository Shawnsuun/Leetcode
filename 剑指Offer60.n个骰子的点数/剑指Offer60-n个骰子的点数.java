class Solution {
    public double[] dicesProbability(int n) {
        double[][] dp = new double[n + 1][];
        dp[0] = new double[]{1.0};
        for (int i = 1; i <= n; i ++) {
            dp[i] = new double[5 * i + 1];
            for (int j = i; j <= 6 * i; j ++) {
                for (int k = 1; k <= 6; k ++) {
                    if (j - k - (i - 1) < 5 * (i - 1) + 1 && j - k - (i - 1) >= 0) {
                        dp[i][j - i] += dp[i - 1][j - k - (i - 1)] / 6;
                    }
                }
            }
        }
        return dp[n];
    }
}