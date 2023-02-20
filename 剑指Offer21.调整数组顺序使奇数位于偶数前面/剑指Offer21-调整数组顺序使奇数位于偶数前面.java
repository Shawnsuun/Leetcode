class Solution {
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < nums.length && (nums[left] & 1) == 1) {
                left ++;
            }
            while (right >= 0 && (nums[right] & 1) == 0) {
                right --;
            }
            if (left < right) {
                swap(nums, left, right);
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}