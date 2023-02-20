class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum + target) % 2 == 1 || sum < target) {
            return 0;
        }
        int tarPos = Math.abs((sum + target) / 2);  //avoid negative array size
        int len = nums.length;
        int[][] dp = new int[len + 1][tarPos + 1];
        dp[0][0] = 1;   //dp[0][0] = 1 is certain, dp[i][0] could be larger since nums[i] can be 0;

        for (int i = 1; i <= len; i ++) {
            for (int j = 0; j <= tarPos; j ++) {
                dp[i][j] = dp[i - 1][j];
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[len][tarPos];
    }
}