class Solution {
    public int minCut(String s) {
        int len = s.length();
        boolean [][] isPal = new boolean[len][len];
        for (int i = 0; i < len; i ++) {
            for (int j = 0; j <= i; j ++) {
                char left = s.charAt(j);
                char right = s.charAt(i);
                if (left == right && (i == j || i == j + 1 || isPal[j + 1][i - 1])) {
                    isPal[j][i] = true;
                }
            }
        }
        int[] dp = new int[len];
        for (int i = 0; i < len; i ++) {
            if (isPal[0][i]) {
                dp[i] = 0;
            } else {
                dp[i] = i;
                for (int j = 1; j <= i; j ++) {
                    if (isPal[j][i]) {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }
        return dp[len - 1];
    }
}