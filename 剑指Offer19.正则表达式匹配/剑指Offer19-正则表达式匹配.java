class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        //case1: s = "", p = ""
        dp[0][0] = true;    
        //case2: s = "", p = "a*b*c*"
        for (int j = 2; j <= p.length(); j += 2) {
            dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';  
        }
        for (int i = 1; i <= s.length(); i ++) {
            for (int j = 1; j <= p.length(); j ++) {
                if (p.charAt(j - 1) == '*') {
                    //case3: s = "ab", p = "abc*"
                    dp[i][j] = dp[i][j - 2] || 
                    //case4: s = "abcc", p = "abc*"
                    (dp[i - 1][j] && s.charAt(i - 1) == p.charAt(j - 2)) || 
                    //case5: s = "abc", p = "ab.*"
                    (dp[i - 1][j] && p.charAt(j - 2) == '.');
                } else {
                    //case6: "abccd", p = "abc*d"
                    //case7: "abccd", p = "abc*.i"
                    dp[i][j] = dp[i - 1][j - 1] && 
                    (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}