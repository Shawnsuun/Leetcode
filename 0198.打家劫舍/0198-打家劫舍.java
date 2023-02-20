class Solution {
    public int rob(int[] nums) {
        //dp function : f(n) = max(f(n - 2) + nums[n], f(n - 1))
        int len = nums.length;
        if (len > 1) {
            int[] dp = new int[] {nums[0], Math.max(nums[0], nums[1])};
            for (int i = 2; i < nums.length; i ++) {
                dp[i % 2] = Math.max(dp[(i - 2) % 2] + nums[i], dp[(i - 1) % 2]);
            }
            return dp[(nums.length - 1) % 2];
        } 
        return nums[0]; 
    }
}