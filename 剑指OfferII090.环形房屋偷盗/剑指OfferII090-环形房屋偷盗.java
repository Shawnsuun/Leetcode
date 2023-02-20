class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        dp1[1] = nums[0];
        dp2[1] = nums[1];
        for (int i = 1; i < len - 1; i ++) {
            dp1[i + 1] = Math.max(dp1[i - 1] + nums[i], dp1[i]);
        }
        for (int i = 1; i < len - 1; i ++) {
            dp2[i + 1] = Math.max(dp2[i - 1] + nums[i + 1], dp2[i]);
        }
        return Math.max(dp1[len - 1], dp2[len - 1]);
    }
}