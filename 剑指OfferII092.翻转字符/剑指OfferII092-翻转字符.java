class Solution {
    public int minFlipsMonoIncr(String s) {
        int len = s.length();
        char[] digits = s.toCharArray();
        int[][] dp = new int[len + 1][2];
        for (int i = 0; i < len; i ++) {
            dp[i + 1][0] = dp[i][0] + (digits[i] - '0');
            dp[i + 1][1] = Math.min(dp[i][0], dp[i][1]) + ('1' - digits[i]);
        }
        return Math.min(dp[len][0], dp[len][1]);
    }
}