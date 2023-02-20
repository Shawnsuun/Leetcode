class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        quicksort(arr, 0, arr.length - 1, k);
        int[] res = new int[k];
        for (int i = 0; i < k; i ++) {
            res[i] = arr[i];
        }
        return res;
    }

    private void quicksort(int[] nums, int start, int end, int k) {
        if (end > start) {
            int pivot = partition(nums, start, end);    //numbers of pivot's left is smaller
            if (pivot == k - 1) {   //find smallest k numbers
                return;
            } else if (pivot > k - 1) { //sort the left side of pivot
                quicksort(nums, start, pivot - 1, k);
            } else {
                quicksort(nums, pivot + 1, end, k); //sort the right side of pivot
            }
        }
    }

    //same to quicksort, get a random number, put numbers smaller on its left
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