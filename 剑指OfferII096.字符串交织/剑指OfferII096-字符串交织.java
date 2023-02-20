class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        char[] chars3 = s3.toCharArray();

        for (int i = 0; i < s1.length(); i ++) {
            dp[i + 1][0] = chars1[i] == chars3[i] && dp[i][0];
        }

        for (int j = 0; j < s2.length(); j ++) {
            dp[0][j + 1] = chars2[j] == chars3[j] && dp[0][j];
        }

        for (int i = 0; i < s1.length(); i ++) {
            for (int j = 0; j < s2.length(); j ++) {
                dp[i + 1][j + 1] = (chars1[i] == chars3[i + j + 1] && dp[i][j + 1]) 
                    || (chars2[j] == chars3[i + j + 1] && dp[i + 1][j]);
            }            
        }
        return dp[s1.length()][s2.length()];
    }
}