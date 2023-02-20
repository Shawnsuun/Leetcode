class Solution {
    public int numWays(int n) {
        //f(n) = f(n - 1) + f(n - 2)
        int MOD = 1000000007;
        int[] dp = new int[2];
        dp[0] = 1;
        for (int i = 1; i <= n; i ++) {
            int temp = dp[(i - 1) % 2];
            dp[i % 2] = (dp[i % 2] + temp) % MOD;                     
        }
        return dp[n % 2];
    }
}