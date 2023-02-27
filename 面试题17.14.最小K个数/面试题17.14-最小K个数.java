class Solution {
    public int[] smallestK(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1, k);
        return Arrays.copyOf(arr, k);
    }

    private void quickSort(int[] nums, int start, int end, int k) {
        if (start < end) {
            int pivot = partition(nums, start, end);
            if (pivot == k - 1) {
                return;
            } else if (pivot > k - 1) {
                quickSort(nums, start, pivot - 1, k);
            } else {
                quickSort(nums, pivot + 1, end, k);
            }
        }
    }

    private int partition(int[] nums, int start, int end) {
        int ran = new Random().nextInt(end - start) + start;
        swap(nums, ran, end);
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
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}