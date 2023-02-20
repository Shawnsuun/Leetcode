class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((target + sum) % 2 == 1 || sum < target) {
            return 0;
        }
        return getTar(nums, (target + sum) / 2);
    }

    private int getTar(int[] nums, int tar) {
        int[][] dp = new int[nums.length + 1][tar + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= nums.length; i ++) {
            dp[i][0] = nums[i - 1] == 0 ? dp[i - 1][0] * 2 : dp[i - 1][0];
        }
        for (int i = 0; i < nums.length; i ++) {
            for (int j = 0; j < tar; j ++) {
                dp[i + 1][j + 1] = dp[i][j + 1];
                if (j + 1 - nums[i] >= 0) {
                    dp[i + 1][j + 1] += dp[i][j + 1 - nums[i]];
                }
            }
        }
        return dp[nums.length][tar];
    }
}