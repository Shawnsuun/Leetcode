class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return countCeiling(nums, right) - countCeiling(nums, left - 1);
    }

    //get number of subarrays that max number is no more than ceiling
    private int countCeiling(int[] nums, int ceiling) {
        int res = 0;
        int cur = 0;
        for (int num : nums) {
            if (num <= ceiling) {
                cur = cur + 1;  //length of subarray, also the number of eligible subarrays
            } else {
                cur = 0;    //length of eligible subarray reset to zero
            }
            res += cur;
        }
        return res;
    }
}