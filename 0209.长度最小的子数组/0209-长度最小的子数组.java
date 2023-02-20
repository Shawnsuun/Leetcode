class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int left = 0;       
        int sum = 0;

        for (int right = 0; right < nums.length; right ++) {
            sum += nums[right];
            while (left <= right && sum >= target) {
                ans = Math.min(right - left + 1, ans);
                sum -= nums[left];
                left ++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}