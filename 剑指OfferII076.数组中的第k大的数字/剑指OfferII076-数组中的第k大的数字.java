class Solution {
    public int findKthLargest(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        int pivot = partition(nums, start, end);
        while (pivot != nums.length - k) {
            if (pivot > nums.length - k) {
                end = pivot - 1;
            } else {
                start = pivot + 1;
            }
            pivot = partition(nums, start, end);
        }
        return nums[pivot];
    }

    private int partition(int[] nums, int start, int end) {
        int random = new Random().nextInt(end - start + 1) + start;
        swap(nums, random, end);

        int small = start - 1;
        for (int i = start; i < end; i ++) {
            if (nums[i] < nums[end]) {
                small ++;
                swap(nums, small, i);
            }
        }
        small ++;
        swap(nums, small, end);
        return small;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}