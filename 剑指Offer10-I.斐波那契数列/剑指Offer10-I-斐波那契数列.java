class Solution {
    public int fib(int n) {
        int MOD = 1000000007;
        int[] dp = new int[] {0, 1};
        for (int i = 2; i <= n; i ++) {
            dp[i % 2] = (dp[0] + dp[1]) % MOD;
        }
        return dp[n % 2];
    }
}