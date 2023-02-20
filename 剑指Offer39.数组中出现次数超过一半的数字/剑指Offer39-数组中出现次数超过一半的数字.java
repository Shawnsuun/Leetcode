class Solution {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len - 1);
        return nums[len / 2];
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int pivot = partition(nums, start, end);
            if (pivot == nums.length / 2) {
                return;
            } else if (pivot > nums.length / 2){
                quickSort(nums, start, pivot - 1);
            } else {
                quickSort(nums, pivot + 1, end);
            }
        }
    }

    private int partition(int[] nums, int start, int end) {
        int random = new Random().nextInt(end - start + 1) + start;
        swap(nums, random, end);
        int small = start - 1;
        for (int i = start; i < end; i ++) {
            if (nums[i] < nums[end]) {
                small ++;
                swap(nums, i, small);
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