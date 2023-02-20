class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        //sliding window
        int sum = 0;
        int len = nums.length;
        int res = len + 1;        
        int left = 0;
        for (int right = 0; right < len; right ++) {
            sum += nums[right];
            while (left <= right && sum >= target) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left];
                left ++;          
            }                                     
        }
        return res > len ? 0 : res;
    }
}