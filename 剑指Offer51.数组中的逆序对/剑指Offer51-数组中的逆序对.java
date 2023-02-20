class Solution {
    private int count;

    public int reversePairs(int[] nums) {
        count = 0;
        int[] dst = new int[nums.length];
        dst = Arrays.copyOf(nums, nums.length);
        mergeSort(nums, dst, 0, nums.length);
        return count;
    }

    private void mergeSort(int[] src, int[] dst, int start, int end) {
        if (start + 1 >= end) {     //sort range is 1
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(dst, src, start, mid);    //swap dst, src
        mergeSort(dst, src, mid, end);
        int i = start, j = mid, k = start;  //i: left ptr, j: right ptr, k: sorted array ptr
        while (i < mid || j < end) {
            if (j == end || (i < mid && src[i] <= src[j])) {    //src[i] = src[j], move ptr i
                dst[k] = src[i];
                i ++;
                k ++;
            } else {
                if (src[i] > src[j]) {      //the only counting condition
                    count += (mid - i);
                }
                dst[k] = src[j];
                j ++;
                k ++;
            }            
        }
    }
}