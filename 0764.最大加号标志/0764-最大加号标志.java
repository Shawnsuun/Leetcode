class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] matrix = new int[n][n];
        for (int[] array : matrix) {
            Arrays.fill(array, 1);
        }
        for (int[] mine : mines) {
            matrix[mine[0]][mine[1]] = 0;
        }
        /**
        f(i, j, k) =
            when matrix[i][j] = 0: 0 
            when matrix[i][j] = 1
                min(
                    f(i, j - 1, 0), 
                    f(i, j + 1, 1)), 
                    f(i - 1, j, 2)), 
                    f(i + 1, j, 3))
                ) + 1
        */
        int[][] dp = new int[n][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, n);
        }
        int res = 0;
        for (int i = 0; i < n; i ++) {
            int leftCount = 0;
            int rightCount = 0;
            //get continuous 1 on matrix[i][j] and its leftside
            for (int j = 0; j < n; j ++) {
                if (matrix[i][j] == 1) {
                    leftCount ++;
                } else {
                    leftCount = 0;
                }
                dp[i][j] = Math.min(dp[i][j], leftCount);
            }
            //get continuous 1 on matrix[i][j] and its rightside
            for (int j = n - 1; j >= 0; j --) {
                if (matrix[i][j] == 1) {
                    rightCount ++;
                } else {
                    rightCount = 0;
                }   
                dp[i][j] = Math.min(dp[i][j], rightCount);             
            }
        }

        for (int j = 0; j < n; j ++) {
            int upCount = 0;
            int downCount = 0;
            //get continuous 1 on matrix[i][j] and its upside
            for (int i = 0; i < n; i ++) {
                if (matrix[i][j] == 1) {
                    upCount ++;
                } else {
                    upCount = 0;
                }
                dp[i][j] = Math.min(dp[i][j], upCount);
            }
            //get continuous 1 on matrix[i][j] and its downside
            for (int i = n - 1; i >= 0; i --) {
                if (matrix[i][j] == 1) {
                    downCount ++;
                } else {
                    downCount = 0;
                }                
                dp[i][j] = Math.min(dp[i][j], downCount);
                res = Math.max(res, dp[i][j]);  
            }
        }
        return res;
    }
}