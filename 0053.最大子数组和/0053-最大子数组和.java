class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int res = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            if (sum < num) {
                sum = num;
            }
            res = Math.max(sum, res); 
        }
        return res;
    }
}