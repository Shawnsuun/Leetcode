class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 + len2 != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];

        dp[0][0] = true;
        for (int i = 0; i < len1; i ++) {
            if (s1.charAt(i) == s3.charAt(i)) {
                dp[i + 1][0] = dp[i][0];
            }
        }
        for (int j = 0; j < len2; j ++) {
            if (s2.charAt(j) == s3.charAt(j)) {
                dp[0][j + 1] = dp[0][j];
            }
        }        
        
        for (int i = 0; i < len1; i ++) {
            for (int j = 0; j < len2; j ++) {
                char ch1 = s1.charAt(i);
                char ch2 = s2.charAt(j);
                char ch3 = s3.charAt(i + j + 1);
                dp[i + 1][j + 1] = ((ch1 == ch3) && dp[i][j + 1]) 
                || ((ch2 == ch3) && dp[i + 1][j]);
            }
        }
        return dp[len1][len2];
    }
}