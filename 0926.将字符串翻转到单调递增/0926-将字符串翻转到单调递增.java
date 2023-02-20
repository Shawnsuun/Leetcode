class Solution {
    public int minFlipsMonoIncr(String s) {
        /**
        dp function: 
            1. f(n) is min flips to make eligible monotone end with 0
                f(n) = s.charAt(n) == '0' ? f(n - 1) : f(n - 1) + 1
            2. g(n) is min flips to make eligible monotone end with 1
                g(n) = s.charAt(n) == '1' ? min(f(n - 1), g(n - 1)) : min(f(n - 1), g(n - 1)) + 1
        */
        int len = s.length();
        int[][] dp = new int[2][len];
        dp[0][0] = s.charAt(0) == '0' ? 0 : 1;
        dp[1][0] = s.charAt(0) == '1' ? 0 : 1;
        for (int i = 1; i < len; i ++) {
            dp[0][i] = s.charAt(i) == '0' ? dp[0][i - 1] : dp[0][i - 1] + 1;
            dp[1][i] = s.charAt(i) == '1' ? Math.min(dp[0][i - 1], dp[1][i - 1]) : Math.min(dp[0][i - 1], dp[1][i - 1]) + 1;            
        }
        return Math.min(dp[0][len - 1], dp[1][len - 1]);
    }
}