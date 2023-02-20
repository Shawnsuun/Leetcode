class Solution {
    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) {
            return 0;
        }
        
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        int len1 = charS.length;
        int len2 = charT.length;

        int[][] dp = new int[len1 + 1][len2 + 1];
        dp[0][0] = 1;
        for (int i = 0; i < len1; i ++) {
            dp[i + 1][0] = 1;
            for (int j = 0; j <= i && j < len2; j ++) {
                if (charS[i] == charT[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + dp[i][j + 1];
                } else {
                    dp[i + 1][j + 1] = dp[i][j + 1];
                }
            }
        }
        return dp[len1][len2];
    }
}