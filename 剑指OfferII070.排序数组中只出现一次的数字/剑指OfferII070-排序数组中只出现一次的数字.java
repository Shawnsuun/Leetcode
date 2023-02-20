class Solution {
    public int singleNonDuplicate(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        if (nums[len - 1] != nums[len - 2]) {
            return nums[len - 1];
        }
        int left = 0;
        int right = len / 2 - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[2 * mid] == nums[2 * mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[2 * left];
    }
}