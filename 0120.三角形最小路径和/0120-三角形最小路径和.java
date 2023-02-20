class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //dp function: f(i, j) = min(f(i - 1, j), f(i - 1, j - 1)) + triangle.get(i).get(j)
        int size = triangle.size();
        int[][] dp = new int[size][size];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < size; i ++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }   
        for (int i = 1; i < size; i ++) {
            for (int j = 1; j < i; j ++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
            }
        }
        int res = Integer.MAX_VALUE;
        for (int sum : dp[size - 1]) {
            res = Math.min(sum, res);
        }
        return res;
    }
}