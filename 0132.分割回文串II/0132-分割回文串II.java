class Solution {
    public int minCut(String s) {
        int len = s.length();
        //create a matrix, save if substring from index j ~ i is palindrome
        boolean[][] isPal = new boolean[len][len];
        for (int i = 0; i < len; i ++) {
            for (int j = 0; j <= i; j ++) {
                char chL = s.charAt(j);
                char chR = s.charAt(i);
                if (chL == chR && (j + 1 > i - 1 || isPal[j + 1][i - 1])) {
                    isPal[j][i] = true;
                }
            }
        } 

        //dp[i] : min partitions of substrings from index 0 ~ i
        int[] dp = new int[len];
        for (int i = 0; i < len; i ++) {
            //substring from index 0 ~ i is palindrome, dp[i] = 0
            if (isPal[0][i]) {
                dp[i] = 0;
            //substring from index 0 ~ i is not palindrome, set dp[i] = i as temporary value
            } else {
                dp[i] = i;
            }
            //check all possible j ~ i substring
            for (int j = 1; j <= i; j ++) {
                //j ~ i substring is palindrome, update dp[i]
                if (isPal[j][i]) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[len - 1];
    }
}