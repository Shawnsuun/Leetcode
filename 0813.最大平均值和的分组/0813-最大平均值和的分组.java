class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        int len = nums.length;
        double[] prefix = new double[len + 1];  //prefix sum
        for (int i = 0; i < len; i ++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        double[][] dp = new double[len + 1][k + 1]; //i: range of num, j: number of subarray
        for (int i = 1; i <= len; i ++) {
            dp[i][1] = prefix[i] / i;  
        }
        for (int j = 2; j <= k ; j ++) {    //j: 2 ~ k subarrays
            for (int i = j; i <= len; i ++) {   //i: num index range j ~ len
                for (int x = j - 1; x < i; x ++) {  //x: cutting index (0~x-1, x~len-1) to make j - 1 subarrays to j subarrays
                    dp[i][j] = Math.max(dp[i][j], dp[x][j - 1] + (prefix[i] - prefix[x]) / (i - x));
                }
            }
        }
        return dp[len][k];
    }
}