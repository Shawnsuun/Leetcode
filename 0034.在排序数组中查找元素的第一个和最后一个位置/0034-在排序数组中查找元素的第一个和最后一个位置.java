class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        return new int[]{binarySearchLeft(nums, target), binarySearchRight(nums, target)};
    }

    private int binarySearchLeft(int[] nums, int tar) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= tar) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left >= 0 && left < nums.length && nums[left] == tar ? left : -1;
    }

    private int binarySearchRight(int[] nums, int tar) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > tar) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right >= 0 && right < nums.length && nums[right] == tar ? right : -1;
    }
}