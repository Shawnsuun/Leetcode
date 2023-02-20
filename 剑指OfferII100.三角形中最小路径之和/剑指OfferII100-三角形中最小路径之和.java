class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 1) return triangle.get(0).get(0);
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i ++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);          
        }
        int res = dp[n - 1][0];
        for (int i = 1; i < n - 1; i ++) {
            for (int j = 1; j <= i; j ++) {
                if (j != i) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                }
            }
        }
        for (int j = 1; j < n; j ++) {
            if (j == n - 1) {
                dp[n - 1][j] = dp[n - 2][j - 1] + triangle.get(n - 1).get(j);
            } else {
                dp[n - 1][j] = Math.min(dp[n - 2][j - 1], dp[n - 2][j]) + triangle.get(n - 1).get(j);
            }
            res = Math.min(res, dp[n - 1][j]);
        }
        return res;
    }
}