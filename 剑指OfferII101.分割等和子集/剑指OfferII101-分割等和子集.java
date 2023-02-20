class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        return helper(nums, sum / 2);
    }

    private boolean helper(int[] nums, int tar) {
        boolean[][] dp = new boolean[nums.length + 1][tar + 1];
        for (int i = 0; i <= nums.length; i ++) {
            dp[i][0] = true;
        }
        for (int i = 0; i < nums.length; i ++) {
            for (int j = 0; j < tar; j ++) {
                dp[i + 1][j + 1] = dp[i][j + 1];
                if (!dp[i + 1][j + 1] && j + 1 - nums[i] >= 0) {
                    dp[i + 1][j + 1] = dp[i][j + 1 - nums[i]];
                }
            }
        }
        return dp[nums.length][tar];
    }
}