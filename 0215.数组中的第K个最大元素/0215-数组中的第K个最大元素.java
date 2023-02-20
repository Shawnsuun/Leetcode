class Solution {
    public int findKthLargest(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        int len = nums.length;
        int index = partition(nums, start, end);
        while (index != len - k) {
            if (index < len - k) {
                start = index + 1;
            } else if (index > len - k) {
                end = index - 1;
            }
            index = partition(nums, start, end);
        }
        return nums[index];
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
        small += 1;
        swap(nums, small, end);
        return small;
    }

    //swap two numbers in an array
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}