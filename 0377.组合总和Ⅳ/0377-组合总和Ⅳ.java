class Solution {
    public int combinationSum4(int[] nums, int target) {
        //dp function: f(i, j) = f(i - 1, j) + f(i - 1, j - nums[i]) 
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int j = 1; j <= target; j ++) {
            for (int num : nums) {
                if (j - num >= 0) {
                    dp[j] = dp[j] + dp[j - num];
                }
            }
        }
        return dp[target];
    }
}