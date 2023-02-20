class Solution {
    public int numDistinct(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        //dp saves distinct subsequence num of substring 0 ~ i in s, and 0 ~ j in t.
        int[][] dp = new int[len1 + 1][len2 + 1];
        dp[0][0] = 1;

        for (int i = 0; i < len1; i ++) {
            //substring of t is ""
            dp[i + 1][0] = 1;
            for (int j = 0; j < len2; j ++) {
                //substring of s is ""
                dp[0][j + 1] = 0;
                //substring of s is shorter than t
                if (i < j) {
                    dp[i + 1][j + 1] = 0;
                //the char of i, j index in s, t is equal
                } else if (s.charAt(i) == t.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + dp[i][j + 1];
                //the char of i, j index in s, t is not equal
                } else {
                    dp[i + 1][j + 1] = dp[i][j + 1];
                }
            }
        }
        return dp[len1][len2];
    }
}