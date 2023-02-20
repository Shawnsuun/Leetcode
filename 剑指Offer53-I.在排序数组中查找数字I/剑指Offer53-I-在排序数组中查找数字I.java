class Solution {
    public int search(int[] nums, int target) {
        int lower = binarySearchLower(nums, target);
        int upper = binarySearchUpper(nums, target);
        int res = upper - lower + 1;
        return res;
    }

    private int binarySearchLower(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {  //num[mid] = target, try to squeeze right range, get the lower index
                right = mid - 1;    //always the last step to end the loop
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int binarySearchUpper(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {  //num[mid] = target, try to squeeze left range, get the upper index
                left = mid + 1; //always the last step to end the loop
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}